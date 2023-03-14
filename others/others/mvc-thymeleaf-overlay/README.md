SPRING BOOT MVC, THYMELEAF AND OVERLAY
======================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to implement overlay (glass) in Spring Boot MVC Thymeleaf project.

#####Details
This project consists of one page:
* **Greeting Page**: this page just displays text "Hello World";
* Page is overlayed by "glass" with message "Example Message".

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

#####Prerequisites:
* Project "mvc-thymeleaf".

#####Implementation details:
* Update file "greeting.html": section with class ".overlay" was added;
* Update file "custom.css": new css class ".overlay" was added.
  

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