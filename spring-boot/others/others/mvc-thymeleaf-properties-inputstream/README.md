SPRING BOOT MVC THYMELEAF AND PROPERTIES FORM INPUT STREAM
==========================================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create Spring Boot application with reading properties from input stream. 

#####Details
This project consists of one page:
* **Greeting Page**: this page just displays text "Hello World".

#####Result 
After copy URL in browser`s address field a user is redirected to Greeting Page. Text "Hello World" is displayed. 
Text is read from properties file by input stream.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

#####Prerequisites:
* None

#####Implementation details:
* Create properties file "greeting.properties" with message;
* Update properties file "application.properties" with name of greeting properties file;
* Create class PropertyService which reads properties from file;
* Update class GreetingController to get message from PropertyService class.
  

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