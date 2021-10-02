package bot.listeners

import game.*
import bot.data.*
import bot.listeners.*
import net.dv8tion.jda.api.hooks.*
import net.dv8tion.jda.api.entities.*
import net.dv8tion.jda.api.events.message.react.*


class ReactionListener private constructor(): ListenerAdapter() {
	companion object {
		private var instance: ReactionListener? = null

		fun getInstance(): ReactionListener {
			if(instance == null) {
				instance = ReactionListener()
			}

			return instance!!
		}
	}

	override fun onMessageReactionAdd(event: MessageReactionAddEvent) {
		reaction(event)
	}

	override fun onMessageReactionRemove(event: MessageReactionRemoveEvent) {
		reaction(event)
	}

	private fun reaction(event: GenericMessageReactionEvent) {
		val on: Boolean = event is MessageReactionAddEvent
		val request: GameRequest? = requests.get(event.getMessageId())
		val game: Game? = runningGames.get(event.getMessageId())
		val emoji: String = try { event.getReactionEmote().getAsCodepoints() }
		catch(e: Exception) { "" }
		val removeReaction: () -> Unit = { if(event.getUser()!= null) event.getReaction().removeReaction(event.getUser()!!).queue() }

		if(event.getUser() != event.getJDA().getSelfUser()) {
			if(request != null) {
	    		when(emoji) {
	    			"U+1f44d" -> when(event.getMember()) {
	        			request.players.first -> request.verify1 = on
	        			request.players.second -> request.verify2 = on
	        			else -> removeReaction()
		        	}

		        	"U+1f44e" -> if(request.players.toList().contains(event.getMember())) {
		        		request.terminate()
		        	}

		        	else -> removeReaction()
	    		}
	    	}

	    	else if(game != null) {
	    		if(game.running()) {
	    			if(game.members.toList().contains(event.getMember()) && emoji == "U+1f91d") {
	        			if(event.getMember() == game.members.first) {
	        				game.draw1 = on
	        			}
	        			
	        			else {
	        				game.draw2 = on
	        			}
	        		}

	    			if(game.currentMember == event.getMember()) {
	    				val direction: Direction? = Direction.values().find{it.unicode == emoji}

	            		if(direction != null) {
	            			game.move(direction)
	      	    		}
   
	       	    		else if(emoji == game.cursor.emoji.first) {
	       	    			game.click()
	       	    			game.render(color = successEC)
	   	        		}

		           		else if(emoji != "U+1f91d") {
	   	        			removeReaction()
	   	        		}
	    			}

	    			else if(emoji != "U+1f91d") {
	    				removeReaction()
	    			}
		    	}
	    	}
	    }
	}
}