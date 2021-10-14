# Ticatoe

Ticatoe is a Discord bot created using Kotlin, Gradle and JDA which allows two users to play tic-tac-toe with each other.

---

## Bot Features

The bot joins a server with an intro from the file `Intro.txt` at `app/src/main/resources`.

The one and only command of this bot is `!tictactoe`, which can be used to play against another person by mentioning them.
`Example: !tictactoe @Jake`

Once this command is used, both players must react with 👍 to a verification message to play or 👎 to not play.

Arrow reaction controls such as ⬆, ⬇, etc. are used to move a cursor. A move is made by reacting with the cursor's emoji. Both players must react with 🤝 if they want a draw.

---

## Self-Hosting

*Note: Must use Java 11 or higher*

Create an environment variable named `TOKEN`, and set its value as your bot token. Use `gradlew run --no-daemon` to run the app. If you want to create an executable jar, use `gradlew build --no-daemon` instead. A jar file named `app.jar` gets stored in the `app/build/libs` directory.

*`--no-daemon` is optional. If it isn't applied, a Gradle daemon keeps runs as a background process.*

---

## Heroku Hosting

Even if you have a free Heroku plan, you need to have a credit card number registered to your account in order to use the button below (as of October, 2021). If you don't, create a new Heroku app. Set an environment variable `TOKEN` as the bot token, and scale your app to one worker dyno before deploying.

<div>
  <a href="https://dashboard.heroku.com/new?button-url=https%3A%2F%2Fgithub.com%2FPrachurja%2FTicatoe&template=https%3A%2F%2Fgithub.com%2FPrachurja%2FTicatoe">
      <img src="https://img.shields.io/badge/deploy_to-heroku-997FBC.svg?style=for-the-badge&logo=Heroku">
  </a>
</div>
