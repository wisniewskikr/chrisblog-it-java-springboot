SPRING BOOT HEROKU
==================


LOCALHOST URL
-------------

* **URL**: https://wisniewskikr-heroku.herokuapp.com/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create Java application with Spring Boot MVC and Thymeleaf and deploy it on Heroku server.

#####Details
This project consists of one page:
* **Greeting Page**: this page just displays text "Hello World".

#####Result 
After copy URL in browser`s address field a user is redirected to Greeting Page. Text "Hello World" is displayed.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
--------------

#####Prerequisites:
* Please deploy this application on Heroku project: "wisniewskikr-heroku".

#####Implementation details:
* Add file Procfile which contains configuration for Heroku;
* Update file Dockerfile - add CMD and $port.


HEROKU CLI
----------
* heroku login
* heroku git:remote --app wisniewskikr-heroku
* git push heroku master
* heroku logs --tail --app wisniewskikr-heroku
* heroku open --app wisniewskikr-heroku


HEROKU DOCKER
-------------
* heroku login
* heroku container:login
* heroku container:push web --app wisniewskikr-heroku
* heroku container:release web --app wisniewskikr-heroku
* heroku logs --tail --app wisniewskikr-heroku
* heroku open --app wisniewskikr-heroku


HEROKU SELENIUM
---------------
Buildpacks:
* https://github.com/heroku/heroku-buildpack-chromedriver
* https://github.com/heroku/heroku-buildpack-google-chrome
* https://github.com/heroku/heroku-buildpack-java.git
Paths:
* **Chrome**: /app/.apt/usr/bin/google-chrome
* **Chrome Driver**: /app/.chromedriver/bin/chromedriver
  

LAUNCH
------

To launch project please run following class: 
* Application.java

You can also launch project using Maven command:
* mvn spring-boot:run -Dspring.thymeleaf.cache=false


USAGE
-----

Link to main UI:
* http://[server]/app/greeting