# gradle-jersey-heroku-webapp

A really, really bare-bones Gradle app using Jersey, which can easily be deployed to Heroku.

## Straightforward deploying to Heroku

1. Fork this repository
1. Go to heroku website, create an app giving any name to it
1. On Deploy -> Deployment method choose github
1. find 'gradle-jersey-heroku-webapp', your fork in your github
1. 'Deploy branch'

## Deploying from local repository to Heroku

### Running locally

You can first test it locally just using gradle. To do so, make sure you have Java installed. 

```sh
$ git clone https://github.com/cleberjamaral/gradle-jersey-heroku-webapp.git
$ cd gradle-jersey-heroku-webapp
$ ./gradlew run
```

Your app should now be running on [localhost:8080](http://localhost:8080/). 

After installing the [Heroku Toolbelt](https://toolbelt.heroku.com/) you can test the app locally using heroku CLI:

```sh
$ ./gradlew stage
$ heroku local web
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

### Deploying from local repository

```sh
$ heroku create
$ git push heroku master
$ heroku open
```

## Credits

This sample project is based on [jersey documentation](https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/getting-started.html#deploy-it-on-heroku), @mgajdos [simple heroku webapp](https://github.com/mgajdos/jersey-simple-heroku-webapp) using maven, [heroku gradle documentation](https://devcenter.heroku.com/articles/deploying-gradle-apps-on-heroku), and [gradle getting started example](https://github.com/heroku/gradle-getting-started) developed by @jkutner which uses spring-boot.
