SPRING BOOT MVC THYMELEAF REDIRECT
==================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how redirect works in project built with Spring Boot MVC and Thymeleaf. 

#####Details
This project consists of two pages:
* Landing Page with link to Greeting page;
* Greeting Page with text "Hello World" and link "Back" to Landing Page.

#####Result 
After click on link on Landing Page user is redirected to Controller and then he is again redirected to Greeting Page.
This second redirection is done by Spring Boot MVC.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

Prerequisites:
* Download project "mvc-thymeleaf".

Implementation details:
* Update class "GreetingController.java" with redirect method;
* Update file "greeting.html" with link with redirection;
* Create file "greeeting-result.html" with displaying text and link back to Landing Page.
  

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