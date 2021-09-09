# Ticatoe

Ticatoe is a Discord bot created using Kotlin, Gradle and JDA which allows two users to play tic-tac-toe with each other.


## Features

The one and only command of this bot is `!tictactoe`, which you can be used to play against another person by mentioning them.
`Example: !tictactoe @Jake`

Once this command is used, both players must react with 👍 to a verification message to play or 👎 to not play.

Arrow reaction controls such as ⬆, ⬇, etc. are used to move a cursor. A move is made by reacting with the cursor's emoji. Both players must react with 🤝 if they want a draw (reaction controls inspired by [Sokobot](https://github.com/PolyMarsDev/Sokobot) by [PolyMars](https://github.com/PolyMarsDev)).


## Self Hosting

### Required Software
* Java 11 or higher

### How to Run
* Download the repo.
* Open the Command Prompt and enter the command:
```bash
setx TOKEN "place your bot token here"
```
* Open a new Command Prompt window. Then enter the commands:
```bash
cd folder\where\you\installed\the\repo
gradlew run --no-daemon
```
* Have some patience as it may take time on the first run. After a while, it should be up and running.

## Conditions
Free to use for non-commercial purposes.
