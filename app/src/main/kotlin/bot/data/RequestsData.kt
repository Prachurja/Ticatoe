package bot.data

import net.dv8tion.jda.api.entities.*
import bot.listeners.*
import bot.embed.*
import java.time.*
import game.*

val runningGames: MutableMap<String, Game> = mutableMapOf()
val commandUsers: MutableMap<Member, LocalTime> = mutableMapOf()
val requests: MutableMap<String, GameRequest> = mutableMapOf()