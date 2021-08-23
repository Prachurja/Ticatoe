package bot

import bot.listeners.*
import java.nio.file.*
import net.dv8tion.jda.api.*
import net.dv8tion.jda.api.entities.*

fun main()
{
	print("Enter your bot token: ")
	
	val jda: JDA = JDABuilder.createDefault(readLine())
   	.setStatus(OnlineStatus.IDLE)
	.setActivity(Activity.playing("!tictactoe @mention"))
   	.build()
    
   	jda.addEventListener(MessageListener.getInstance(), ReactionListener.getInstance())
}
