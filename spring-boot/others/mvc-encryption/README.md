SPRING BOOT MVC AND STRING ENCRYPTION
=====================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

This is simple Spring Boot MVC project which displays "Hello World" text. 
Main goal of this project is to show how text encryption and decryption works.
Password is required to encrypt and decrypt text.

Used technologies:
* **BE**: Spring Boot MVC


IMPLEMENTATION
-----------

Prerequisites:
* Downloaded template application ** "mvc" ** .

Implementation details:
* Add utils class EncryptionUtils.java. This class encrypts and decrypts text using password;
* Add service class EncryptionService.java. This class calls class EncrytpionUtils and takes password from properties;
* Update controller class GreetingController.java. This class calls class EncrtyptionService and returns String with encrypted and decrypted text as result;
* Update file application.properties. Property "encryption.password" with password value should be added there.
  

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