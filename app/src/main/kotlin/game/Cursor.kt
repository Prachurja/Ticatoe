package game

class Cursor
{
	val emoji: Pair<String, String> = listOf("U+1f538" to ":small_orange_diamond:",
		"U+1f53a" to ":small_red_triangle:",
		"U+25fd" to ":white_medium_small_square:",
		"U+1f539" to ":small_blue_diamond:").random()

	var x: Int = 0
	var y: Int = 0
}