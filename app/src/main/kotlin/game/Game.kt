package game

import net.dv8tion.jda.api.entities.*
import net.dv8tion.jda.api.*
import java.time.*
import game.Game
import bot.embed.*
import bot.data.*

class Game(val message: Message, val members: Pair<Member, Member>): Thread() {
	private val grid: Array<Array<String>> = Array<Array<String>>(3){ Array<String>(3){ ":black_large_square:" }}

	val cursor: Cursor = Cursor()
	var currentMember: Member = members.toList().random()
	var currentEmoji: String = ":x:"
	var draw1: Boolean = false
	var draw2: Boolean = false
	var stopped: Boolean = false

	override fun run() {
		runningGames.put(message.getId(), this)

		(Direction.values().map{ it.unicode } + listOf(cursor.emoji.first, "U+1f91d")).forEach{ message.addReaction(it).queue() }
		
		render()
		while(running()){}
		
		Thread.sleep(2000)
		stopped = true

		if(draw()) {
			render("${members.first.getAsMention()} and ${members.second.getAsMention()} are tied.", tieEC, showCursor = false, runningSpecial = true)
		}

		else if(!running()) {
			render("${currentMember.getAsMention()} has won the game. Congrats! :tada:", winEC, showCursor = false, runningSpecial = true)
		}
		
		runningGames.remove(message.getId())
	}

	fun running(): Boolean {
		val completed: (Array<String>) -> Boolean = {it.distinct().size == 1 && !it.distinct().contains(":black_large_square:")}

		return (0..2).map{grid[it]}.filter{completed(it)}.size == 0 &&
		(0..2).map{ j-> completed((0..2).map{ i -> grid[i][j]}.toTypedArray())}.filter{it == true}.size == 0 &&
		!completed((0..2).map{ grid[it][it] }.toTypedArray()) &&
		!completed((0..2).map{ grid[it][(2 downTo 0).elementAt(it)] }.toTypedArray()) && !draw()
	}

	fun draw(): Boolean {
		return (!grid.map{it.joinToString()}.joinToString().contains(":black_large_square:") && running()) || (draw1 && draw2)
	}

	fun click() {
		if(grid[cursor.x][cursor.y] == ":black_large_square:") {
			grid[cursor.x][cursor.y] = currentEmoji

			if(running()) {
				currentMember = if(currentMember == members.first) members.second else members.first
				currentEmoji = if(currentEmoji == ":x:") ":o:" else ":x:"
				
				if(running() && !draw()) render(showCursor = false)
			}
		}

		else {
			render(comment = "${currentMember.getAsMention()} a move was already made in this position.", showCursor = false)
		}
	}

	fun move(direction: Direction) {
		val newX: Int = cursor.x + direction.x
		val newY: Int = cursor.y + direction.y

		if(newX <= 2 && newX >= 0 && newY <= 2 && newY >= 0) {
			cursor.x = newX
			cursor.y = newY
		}

		render()
	}

	fun render(comment: String = "${currentMember.getAsMention()}'s turn", color: EmbedColor = normalEC, showCursor: Boolean = true, runningSpecial: Boolean = false) {
		if(!stopped || runningSpecial) {
			val copy: Array<Array<String>> = Array<Array<String>>(3){ Array<String>(3){""} }
			for(i in 0..2) for(j in 0..2) copy[i][j] = grid[i][j]
			
			if(showCursor) copy[cursor.x][cursor.y] = cursor.emoji.second
			message.editMessage(comment).queue()
			
			message.editMessage(EmbedBuilder()
					.setTitle(copy.map{it.joinToString("")}.joinToString("\n"))
					.setColor(color.generate())
					.build())
				.queue()
		}
	}
}