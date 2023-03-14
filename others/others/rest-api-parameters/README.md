SPRING BOOT REST API AND PARAMETERS
===================================


LOCALHOST URL
-------------

* URL GET: http://localhost:8080/app/greeting?name=John
* URL POST: http://localhost:8080/app/greeting - JSON {"name":"John"}


DESCRIPTION
-----------

This is simple Spring Boot REST API project which displays "Hello World + name" text in JSON. 

Used technologies:
* BE: Spring Boot REST API
  

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