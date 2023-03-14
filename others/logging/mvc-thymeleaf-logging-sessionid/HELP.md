SPRING BOOT MVC, THYMELEAF AND LOGGING SESSION ID
=================================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create Java application with Spring Boot MVC, Thymeleaf 
which logs user session id for every method. In this way administrator will be able to trace activity by user. 

#####Details
This project consists of one page:
* **Greeting Page**: this page just displays text "Hello World".

#####Result 
After copy URL in browser`s address field a user is redirected to Greeting Page. Text "Hello World" is displayed.

#####Used technologies:
* **BE**: Spring BootC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

#####Prerequisites:
* This project extends project **mvc-thymeleaf**

#####Implementation details:
* Update file pom.xml: added dependencies for aspects;
* Create class LoggingAspects: added class which creates logs with session id;
* Update file application.properties: configure logs.
  

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