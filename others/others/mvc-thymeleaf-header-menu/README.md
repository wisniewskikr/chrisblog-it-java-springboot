SPRING BOOT MVC THYMELEAF AND HEADER MENU
=========================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to implement header with menu using Spring Boot MVC and Thymeleaf. 

#####Details
This project consists of following pages:
* Greeting Page with text "Hello World" and header with menu;
* GreetingSecond Page with text "Hello World Second" and header with menu;

#####Result 
After paste URL in browser's address field the Greeting Page is displayed.
Greeting Page contains text "Hello World" and header with menu. Menu item "Greeting" should be highlighted.
After click on menu "Greeting Second" user should be redirected to GreetingSecond Page with text "Hello World Second"
and header with menu. Menu item "Greeting Second" should be highlighted.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

Prerequisites:
* Download project "mvc-thymeleaf".

Implementation details:
* Update class "GreetingController.java" and add "greetingSecond" handling;
* Create file "header.html" with header details;
* Update file "greeting.html" with connection to footer;
* Create file "greetingSecond.html" with connection to footer;
* Update file "custom.css" with CSS class "selected".
  

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