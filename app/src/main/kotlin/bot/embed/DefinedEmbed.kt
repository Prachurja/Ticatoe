package bot.embed

import java.awt.Color
import net.dv8tion.jda.api.entities.*
import net.dv8tion.jda.api.*

data class DefinedEmbed(val embedColor: EmbedColor, val titles: List<String>)
{
	fun generate(description: String): MessageEmbed
	{
		return EmbedBuilder()
		.setTitle(titles.random())
		.setColor(embedColor.generate())
		.setDescription(description)
		.build()
	}
}