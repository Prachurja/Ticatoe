package game

enum class Direction(val x: Int, val y: Int, val unicode: String)
{
	UP(-1, 0, "U+2b06U+fe0f"),
	DOWN(1, 0, "U+2b07U+fe0f"),
	LEFT(0, -1, "U+2b05U+fe0f"),
	RIGHT(0, 1, "U+27a1U+fe0f"),
	UP_LEFT(-1, -1, "U+2196U+fe0f"),
	UP_RIGHT(-1, 1, "U+2197U+fe0f"),
	DOWN_LEFT(1, -1, "U+2199U+fe0f"),
	DOWN_RIGHT(1, 1, "U+2198U+fe0f");
}