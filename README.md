# Ticatoe

Ticatoe is a Discord bot created using Kotlin, Gradle and JDA which allows two users to play tic-tac-toe with each other.

### Features

The one and only command of this bot is **!tictactoe**, which you can be used to play against another person by mentioning them.
*Example: !tictactoe @Jake*

Once this command is used, both players must react with 👍 to a verification message to play or 👎 to not play.

Arrow reaction controls such as ⬆, ⬇, etc. are used to move a cursor. A move is made by reacting with the cursor's emoji. Both players must react with 🤝 if they want a draw (reaction controls inspired by [Sokobot](https://github.com/PolyMarsDev/Sokobot) by [PolyMars](https://github.com/PolyMarsDev)).

### Steps for Self Hosting

1. Install JDK 11 or higher.
2. Run the command - **setx TOKEN "*enter your bot token here*"**
3. Install the repo and navigate to the folder using the command line.
4. Enter the command - **gradlew run**

##### Conditions

Free to use for non-commercial purposes.
