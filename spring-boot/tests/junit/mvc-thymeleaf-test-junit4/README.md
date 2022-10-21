SPRING BOOT MVC, THYMELEAF AND JUNIT 4
======================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

This example bases on simple Spring Boot MVC project which displays "Hello World" text. 
Main goal of this project is to show how to implement JUnit 4 tests.

Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
--------------

Prerequisites:
* Downloaded project "mvc-thymeleaf".

Implementation details:
* Update file pom.xml with artifact "spring-boot-starter-test";
* Create JUnit test class GreetingControllerTest.java.


LAUNCH TESTS
------------

To launch tests you can use Maven command:
* mvn clean install
  

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