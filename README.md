# Ticatoe

Ticatoe is a Discord bot created using Kotlin, Gradle and JDA which allows two users to play tic-tac-toe with each other.

---

## Features

The one and only command of this bot is `!tictactoe`, which can be used to play against another person by mentioning them.
`Example: !tictactoe @Jake`

Once this command is used, both players must react with 👍 to a verification message to play or 👎 to not play.

Arrow reaction controls such as ⬆, ⬇, etc. are used to move a cursor. A move is made by reacting with the cursor's emoji. Both players must react with 🤝 if they want a draw (reaction controls inspired by [Sokobot](https://github.com/PolyMarsDev/Sokobot) by [PolyMars](https://github.com/PolyMarsDev)).

---

## Self-Hosting

*Note: Must use Java 11 or higher*

Create an environment variable named `TOKEN`, and set its value as your bot token. Use `gradlew build --no-daemon` to build the app. A jar file by the name, `app.jar` would get stored in the `app/build/libs` folder. You can run the jar using the `java -jar` command.
