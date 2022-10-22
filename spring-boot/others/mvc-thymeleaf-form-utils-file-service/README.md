SPRING BOOT MVC AND THYMELEAF WITH FORM - FILE SERVICE
======================================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create Spring Boot MVC and Thymeleaf application which can write and read files.

In this example name is written in file "tmp.txt" and then read from there. Just for test purpose.

#####Details
This project consists following pages:
* **Greeting Page**: this page contains input filed with name. After submit text "Hello World" + name is displayed below input field.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

Prerequisites:
* This project is based on existing project "mvc-thymeleaf-form".

Implementation details:
* Update class GreetingController: added writing and reading files;
* Create class FileService: this class contains methods for writing and reading files. 
  

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