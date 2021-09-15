package bot.listeners

import game.*
import bot.data.*
import bot.embed.*
import bot.listeners.*

import java.time.*
import java.nio.file.*
import net.dv8tion.jda.api.*
import net.dv8tion.jda.api.hooks.*
import net.dv8tion.jda.api.entities.*
import net.dv8tion.jda.api.events.guild.*
import net.dv8tion.jda.api.events.message.guild.*


class MessageListener private constructor(): ListenerAdapter()
{
	companion object
	{
		private var instance: MessageListener? = null

		fun getInstance(): MessageListener
		{
			if(instance == null)
			{
				instance = MessageListener()
			}

			return instance!!
		}
	}

	override fun onGuildJoin(event: GuildJoinEvent)
	{
		event.getGuild().getDefaultChannel()?.sendMessage(EmbedBuilder()
			.setDescription(Files.readAllLines(Path.of("Intro.txt")).joinToString("\n"))
			.setThumbnail(event.getJDA().getSelfUser().getEffectiveAvatarUrl())
			.setColor(java.awt.Color(57, 15, 105))
			.build())
		?.queue()
	}

	override fun onGuildMessageReceived(event: GuildMessageReceivedEvent)
	{
		val messageText: String = event.getMessage().getContentRaw()
		
		if(messageText.startsWith("!tictactoe"))
		{
			val mentioned: List<Member> = event.getMessage().getMentionedMembers()
	    	val secondsToWait: Long = 10

	    	when(mentioned.size)
	    	{
	    		0 ->
	    		{
	    			event.getMessage()
	     			.reply(EmbedData.errorEmbed.generate("You need to mention the player to play against!"))
	    			.queue()
	    		}

	    		1 ->
	    		{
	    			if(!RequestsData.commandUsers.containsKey(event.getMember()!!))
	    			{
	    				RequestsData.commandUsers.put(event.getMember()!!, LocalTime.now().minusMinutes(1))
	    			}

	    			val sinceLastCMD: Duration = Duration.between(RequestsData.commandUsers.get(event.getMember()!!), LocalTime.now())
	    			val waitedEnough: Boolean = sinceLastCMD.toSeconds() >= secondsToWait
	    			val players: Pair<Member, Member> = event.getMember()!! to mentioned.get(0)
			    
	    		    if(players.toList().toSet().size == 1)
	    		    {
	    		    	event.getMessage()
	    	    	    .reply(EmbedData.errorEmbed.generate("You can't play against yourself."))
	    	    	    .queue()
	    		    }

	    		    else if(players.toList().filter{it.getUser().isBot()}.size > 0)
	    		    {
	    		    	event.getMessage()
	    	    	    .reply(EmbedData.errorEmbed.generate("You can't play against a bot."))
	    	    	    .queue()
	    		    }

		            else if(waitedEnough)
		            {
		            	event.getMessage()
	     	        	.getChannel()
	       	            .sendMessage(Responses.REACT.generate(players))
	         	        .queue()

	        	        RequestsData.commandUsers.put(event.getMember()!!, LocalTime.now())
		            }

		            else
		            {
		            	val secondsToWaitMore: Long = secondsToWait - sinceLastCMD.toSeconds()

		            	event.getMessage()
	   	            	.getChannel()
	   	            	.sendMessage(EmbedData.tooFastEmbed.generate("There's a $secondsToWait seconds cooldown. You have to wait for $secondsToWaitMore seconds before you can use this command again."))
	        	        .queue()
		            }
	    		}

	    		else ->
	    		{
	    			event.getMessage()
	    		    .reply(EmbedData.errorEmbed.generate("You can't play tic-tac-toe with multiple players, can you?"))
	    		    .queue()
	    		}
	    	}
		}

		else if(event.getMessage().getAuthor() == event.getJDA().getSelfUser())
		{
			val pair: Pair<Member, Member>? = event.getMessage().getMentionedMembers().zipWithNext().getOrNull(0)

			if(pair != null)
			{
				if(messageText.equals(Responses.REACT.generate(pair)))
	       		{
	       			val request: GameRequest = GameRequest(LocalTime.now(), pair, event.getMessage())

	       			listOf("U+1f44d", "U+1f44e").forEach{event.getMessage().addReaction(it).queue()}
	       			RequestsData.requests.put(event.getMessage().getId(), request)
	       		}

	       		else if(messageText.equals(Responses.GETREADY.generate(pair)))
	       		{
		       		val game: Game = Game(event.getMessage(), pair)
		           	game.start()
		       	}
			}
		}
	}
}
