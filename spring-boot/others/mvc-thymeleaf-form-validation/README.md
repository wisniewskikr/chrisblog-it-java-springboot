SPRING BOOT MVC, THYMELEAF WITH FORM AND VALIDATION
===================================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show to implement validation using technologies Spring Boot MVC and Thymeleaf. 

#####Details
This project consists following pages:
* Greeting Page: this page contains input filed with name. After submit text "Hello World" + name is displayed below input field. 
But if field "Name" is empty then validation error is displayed.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

Prerequisites:
* This project is an extension of project "mvc-thymeleaf-form". Only differences between these two projects are displayed here.

Implementation details:
* Update file pom.xml: add dependencies with validation;
* Update class GreetingCommand: add annotation @NotBlank;
* Update class GreetingController: add annotation @Valid and class BindingResult;
* Update file greeting.html: add element for validation message;
* Update file custom.css: add style of validation message.
  

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