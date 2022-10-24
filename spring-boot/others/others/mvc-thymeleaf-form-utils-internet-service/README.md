SPRING BOOT MVC AND THYMELEAF WITH FORM - UTILS INTERNET SERVICE
================================================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create Spring Boot MVC and Thymeleaf application which can read some page from Internet.

Example page which can be read: https://chrisblog.eu/article/13
Count should be: 5.

#####Details
This project consists following pages:
* **Greeting Page**: this page contains input filed with url. 
When user clicks "Submit" button then site located on this url is read and text "Hello World" is counted.
Message with this count is displayed on page.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

Prerequisites:
* This project is based on existing project "mvc-thymeleaf-form".

Implementation details:
* Update class GreetingCommand.java			: added Internet page reading;
* Update class GreetingController.java		: renamed field from "name" to "url";
* Update file "greeting.html"				: renamed element from "name" to "url";
* Add class InternetReaderService			: this class contains method for reading page.
  

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


ADDITIONAL
----------

Library for html:
* jsoup