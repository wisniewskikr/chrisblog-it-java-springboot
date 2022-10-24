SPRING BOOT MVC THYMELEAF FOOTER
================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to implement footer with Spring Boot MVC and Thymeleaf. 

#####Details
This project consists of following pages:
* Greeting Page with text "Hello World" footer with text "Footer".

#####Result 
After paste URL in browser's address field the Greeting Page is displayed.
Greeting Page contains text "Hello World" and footer with text "Footer".

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

Prerequisites:
* Download project "mvc-thymeleaf".

Implementation details:
* Create file "footer.html" with footer details;
* Update file "greeting.html" with connection to footer.
  

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