SPRING BOOT MVC THYMELEAF WITH UNESCAPED TEXT
=============================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

This is simple Spring Boot MVC project which displays "Hello World" text. 
Main goal of this example is to show how to use unescaped text in thymeleaf.

Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

Prerequisites:
* Downloaded project "mvc-thymeleaf".

Implementation details:
* Update class GreetingController.java. Add html elements to String;
* Update file "greeting.html". Change thymeleaf attribute from "th:text" to "th:utext".
  

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