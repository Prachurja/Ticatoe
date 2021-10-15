# Ticatoe

Ticatoe is a Discord bot created using Kotlin, Gradle and JDA (Java Discord API) which allows two users to play tic-tac-toe with each other.

---

## Bot Features

The bot joins a server with an intro from the file `Intro.txt` at `app/src/main/resources`.

The one and only command of this bot is `!tictactoe`, which can be used to play against another person by mentioning them.
`Example: !tictactoe @Jake`

Once this command is used, both players must react with 👍 to a verification message to play or 👎 to not play.

Arrow reaction controls such as ⬆, ⬇, etc. are used to move a cursor. A move is made by reacting with the cursor's emoji. Both players must react with 🤝 if they want a draw.

---

## Hosting

*You must create an application using the Discord Developer Portal and create a bot for the application before using any of the below options.*

### Local

*Note: Must use Java 11 or higher*

Create an environment variable named `TOKEN`, and set its value as your bot token. Use `gradlew run` to run the app. If you want to create an executable jar, use `gradlew build` instead. A jar file named `app.jar` gets stored in the `app/build/libs` directory.

*You can add `--no-daemon` after the `gradlew run` or `gradlew build` if you don't want a [Gradle daemon](https://docs.gradle.org/current/userguide/gradle_daemon.html) running as a background process.*

---

### Heroku

Press the button below to deploy the app to Heroku. Once deployed, click on `Manage App`. Go to the `Resources` tab. Click on the pencil icon beside `worker java -jar app/build/libs/app.jar`. Toggle the switch on, then confirm.

<button>
  <a href="https://dashboard.heroku.com/new?button-url=https%3A%2F%2Fgithub.com%2FPrachurja%2FTicatoe&template=https%3A%2F%2Fgithub.com%2FPrachurja%2FTicatoe">
      <img src="https://www.herokucdn.com/deploy/button.svg">
  </a>
</button>
