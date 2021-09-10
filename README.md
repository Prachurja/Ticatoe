# Ticatoe

Ticatoe is a Discord bot created using Kotlin, Gradle and JDA which allows two users to play tic-tac-toe with each other.


## Features

The one and only command of this bot is `!tictactoe`, which you can be used to play against another person by mentioning them.
`Example: !tictactoe @Jake`

Once this command is used, both players must react with 👍 to a verification message to play or 👎 to not play.

Arrow reaction controls such as ⬆, ⬇, etc. are used to move a cursor. A move is made by reacting with the cursor's emoji. Both players must react with 🤝 if they want a draw (reaction controls inspired by [Sokobot](https://github.com/PolyMarsDev/Sokobot) by [PolyMars](https://github.com/PolyMarsDev)).


## Self-Hosting

### Required Software
* Java 11 or higher

### Compiling
* Install the repo.
* In the root folder, run the command `gradlew build --no-daemon`.
* A jar file by the name `app.jar` would be created in the `app\build\libs` folder. Navigate to the folder and run the jar using the command `java -jar app.jar`.
