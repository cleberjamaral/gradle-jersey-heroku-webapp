# gradle-jersey-heroku-webapp

A really, really bare-bones Gradle app using Jersey, which can easily be deployed to Heroku.

## Running Locally

Make sure you have Java installed. Also, install the [Heroku Toolbelt](https://toolbelt.heroku.com/).

```sh
$ git clone https://github.com/cleberjamaral/gradle-jersey-heroku-webapp.git
$ cd gradle-jersey-heroku-webapp
$ ./gradlew stage
$ heroku local web
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

## Deploying to Heroku

Make sure you have heroku [CLI installed](https://devcenter.heroku.com/articles/heroku-cli)

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Credits

This sample project is based on [jersey documentation](https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/getting-started.html#deploy-it-on-heroku), @mgajdos [simple heroku webapp](https://github.com/mgajdos/jersey-simple-heroku-webapp) using maven, [heroku gradle documentation](https://devcenter.heroku.com/articles/deploying-gradle-apps-on-heroku), and [gradle getting started example](https://github.com/heroku/gradle-getting-started) developed by @jkutner which uses spring-boot.