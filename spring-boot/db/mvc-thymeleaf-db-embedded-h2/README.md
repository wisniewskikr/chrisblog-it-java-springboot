SPRING BOOT MVC, THYMELEAF AND EMBEDDED DB H2
=============================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting
* **URL for DB Console**: http://localhost:8080/app/console (credentials: sa/password)


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create Java application with Spring Boot MVC and Thymeleaf
and embedded database H2. 

#####Details
This project consists of one page:
* **Greeting Page**: this page just displays text "Hello World". This text is stored in embedded database H2.

#####Result 
After copy URL in browser`s address field a user is redirected to Greeting Page. Text "Hello World" is displayed.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

#####Prerequisites:
* This project is based on existing project "mvc-thymeleaf".

#####Implementation details:
* Update file pom.xml with JPA and H2 dependencies;
* Update file application.properties with datasource and H2 properties;
* Create file data.sql with insert text "Hello World!" query;
* Create class GreetingEntity with table structure;
* Create class GreetingRepository with database methods;
* Update class GreetingController with reading data from database;
* Update class Application with location of entities and repositories packages.
  

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
* http://[server]/app/console (credentials: sa/password)