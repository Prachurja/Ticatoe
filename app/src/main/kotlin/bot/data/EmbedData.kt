package bot.data

import bot.embed.*

class EmbedData private constructor()
{
	companion object
	{
		val errorEC: EmbedColor = EmbedColor(150 to 255, 51 to 139, 51 to 85)
    	private val errorTitles: List<String> = listOf("Error :stop_sign:",
    		"No, no ${listOf(":man_gesturing_no:", ":no_good:", ":woman_gesturing_no:").random()}",
    		"Oof, that was a mistake ${listOf(":man_facepalming:", ":face_palm:", ":woman_facepalming:").random()}",
    		"Houston, we have a problem :warning:")

    	val errorEmbed: DefinedEmbed = DefinedEmbed(errorEC, errorTitles)


    	val tooFastEC: EmbedColor = EmbedColor(0 to 0, 160 to 240, 160 to 210)
    	private val tooFastTitles: List<String> = listOf("Cool your jets :rocket:",
    		"Too spicy :hot_pepper:",
    		"Hold your horses :horse_racing:",
    		"Slow down :stopwatch:",
    		"Easy on the commands there :stop_sign:")

    	val tooFastEmbed: DefinedEmbed = DefinedEmbed(tooFastEC, tooFastTitles)


    	val normalEC: EmbedColor = EmbedColor(255 to 255, 230 to 255, 80 to 120)
    	val successEC: EmbedColor = EmbedColor(100 to 170, 255 to 255, 100 to 180)
    	var winEC: EmbedColor = EmbedColor(170 to 200, 130 to 170, 255 to 255)
    	var tieEC: EmbedColor = EmbedColor(220 to 240, 220 to 240, 200 to 225, true)
	}
}