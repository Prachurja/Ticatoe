package game

import bot.data.*
import java.time.LocalTime
import net.dv8tion.jda.api.entities.*

data class GameRequest(val time: LocalTime, var players: Pair<Member, Member>, var message: Message) {
	private fun onceVerified() {
		message.delete().queue()
     		message.getChannel().sendMessage(Responses.GETREADY.generate(players)).queue()
       		requests.remove(message.getId())
	}

	fun terminate() {
		requests.remove(message.getId())
		
		message.editMessage("${players.first.getAsMention()} requested a game with ${players.second.getAsMention()} but it was cancelled from either side.").queue()
		message.clearReactions().queue()
	}

	var verify1: Boolean = false
	set(value) {
		if(value && verify2) {
			onceVerified()
		}

		field = value
	}

	var verify2: Boolean = false
	set(value) {
		if(value && verify1) {
			onceVerified()
		}

		field = value
	}
}
