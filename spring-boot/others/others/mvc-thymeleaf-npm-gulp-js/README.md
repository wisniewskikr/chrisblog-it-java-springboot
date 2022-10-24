SPRING BOOT MVC, THYMELEAF AND NPM AND GULP
===========================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create Java application with Spring Boot MVC and Thymeleaf 
and FE tasks Npm and Gulp. These tasks are done by Maven in "generate-resources" phase:
* **Npm**: enables download js libraries. It's configured in file: **package.json**;
* **Gulp**: enables run js functions by Maven. It's configured in file: **gulpfile.js**. 

#####Details
This project consists of one page:
* **Greeting Page**: this page just displays text "Hello World".

#####Result 
Maven command "mvn clean install" should download js library and using this library following text should be displayed on Console: **Hello World Npm and Gulp!**.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

#####Prerequisites:
* None

#####Implementation details:
* Update file pom.xml with plugin **frontend-maven-plugin**;
* Create file package.json with configuration for Npm;
* Create file gulpfile.js with configuration for Gulp.
  

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