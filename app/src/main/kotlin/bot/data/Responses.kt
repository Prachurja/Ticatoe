package bot.data

import net.dv8tion.jda.api.entities.*

enum class Responses(val message: String) {
	REACT("player1 and player2, react with :thumbsup: to start playing! :thumbsdown: to not play."),
	GETREADY("player1 and player2, get ready! Your game is starting soon."),
	LATE("player1 requested a game with player2 but they couldn't react in time."),
	START("player1 and player2, your game is starting soon.");

	fun generate(players: Pair<Member, Member>): String {
		val mentions: Set<String> = players.toList().map{ it.getAsMention() }.toSet()
		return message.replace("player1", mentions.first())
		.replace("player2", mentions.toList().get(1))
	}

	fun regex(): Regex {
		return Regex(message.replace("player1-player2", "<@\\d+>")
		.replace("player1", "<@\\d+>")
		.replace("player2", "<@\\d+>"))
	}
}