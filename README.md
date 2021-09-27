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

### Prerequisites
* Java 11 or higher
* An environment variable named `TOKEN`, its value being the bot token
* Stable Internet connection as it will install some dependencies the first time you run

### Method 1
Use the `gradlew run --no-daemon` command to run the app. [`--no-daemon`](https://docs.gradle.org/current/userguide/gradle_daemon.html#sec:disabling_the_daemon) is optional. Applying this flag stops the [Gradle Daemon](https://docs.gradle.org/current/userguide/gradle_daemon.html) after the build. Otherwise it keeps running as a background task.

### Method 2
Use `gradlew build --no-daemon` to build the app. A jar file by the name, `app.jar` would get stored in the `app/build/libs` folder. You can run the jar using the `java -jar` command.

---

## Invite
[BOT INVITE LINK](https://discord.com/api/oauth2/authorize?client_id=859417039017607170&permissions=10304&scope=bot) - if you want to test its features.

---

## License
Licensed under the GPL v3 License, a strong copyleft license. This means that any copy or modification of the original code must also be made released under the GPL v3. For further information, see the [LICENSE](https://github.com/Prachurja/Ticatoe/blob/main/LICENSE) file.
