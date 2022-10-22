SPRING BOOT MVC, THYMELEAF AND CUSTOM ANNOTATION TRACEABLE
==========================================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create custom annotation to trace methods in Java application with Spring Boot MVC and Thymeleaf. 

#####Details
This project consists of one page:
* **Greeting Page**: this page just displays text "Hello World". Additionally in console is displayed duration of method "greeting".

#####Result 
After copy URL in browser`s address field a user is redirected to Greeting Page. Text "Hello World" is displayed. Additionally in console is displayed duration of method "greeting". 

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

#####Prerequisites:
* This project is an extension of project "mvc-thymeleaf". Only differences between these two projects are displayed here.

#####Implementation details:
* Update file pom.xml: add dependencies for aspects;
* Create interface Traceable: custom annotation;
* Create class TraceableAspect: aspect for custom annotation;
* Update class GreetingController: add custom annotation Traceable abobe method "greeting".
  

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