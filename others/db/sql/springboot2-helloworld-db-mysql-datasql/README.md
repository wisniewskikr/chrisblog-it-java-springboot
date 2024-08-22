docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=my_secret_password -e MYSQL_DATABASE=database -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin123 -p 3306:3306 mysql:5.7

SPRING BOOT MVC, THYMELEAF AND MYSQL
=============================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create Java application with Spring Boot MVC and Thymeleaf
and database MySQL.

#####Details
This project consists of one page:
* **Greeting Page**: this page just displays text "Hello World". This text is stored in database MYSQL.

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
* Update file pom.xml with JPA and MySql dependencies;
* Update file application.properties with datasource and MySql properties;
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