package bot.embed

import java.awt.Color
import kotlin.random.Random
import kotlin.math.*

class EmbedColor(val rRange: Pair<Int, Int>, val gRange: Pair<Int, Int>, val bRange: Pair<Int, Int>, var grayAllowed: Boolean = false) {
	fun generate(): Color {
		val r: Int = Random.nextInt(rRange.first, rRange.second+1)
		val g: Int = Random.nextInt(gRange.first, gRange.second+1)
		val b: Int = Random.nextInt(bRange.first, bRange.second+1)

		val arr: Array<Int> = arrayOf(r, g, b)
		val mean: Double = arr.average()

		if(arr.filter{ (max(it.toDouble(), mean) - min(it.toDouble(), mean)) >= 25 }.size < 3 && !grayAllowed) return generate()
		return Color(r, g, b)
	}
}