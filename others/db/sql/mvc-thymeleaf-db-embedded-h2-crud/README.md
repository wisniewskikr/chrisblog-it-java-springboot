SPRING BOOT MVC, THYMELEAF AND EMBEDDED DATABASE H2 CRUD OPERATIONS
===================================================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app


DESCRIPTION
-----------

#####Goal
The goal of this project is to show to create Spring Boot MVC and Thymeleaf application which handles CRUD operations (Create, Read, Update, Delete)
on embedded H2 database.. 

#####Details
This project consists following pages:
* List Page: page with list of names and links: Create, View, Update and Delete;
* Create Page: page where you can create new user;
* View Page: page where you can see name of selected user;
* Update Page: page where you can update name of selected user;
* Delete Page: page where you can update selected user.

#####Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf
* **BE**: Embedded H2


IMPLEMENTATION
-----------

Prerequisites:
* This project is based on existing project "mvc-thymeleaf".

Implementation details:
* Update file pom.xml with JPA and H2 dependencies;
* Update file application.properties with datasource and H2 properties;
* Create class UserEntity with table structure;
* Create class UserRepository with database methods;
* Create classes ListController and ListCommand and create file list.html;
* Create classes CreateController and CreateCommand and create file create.html;
* Create classes ViewController and ViewCommand and create file view.html;
* Create classes UpdateController and UpdateCommand and create file update.html;
* Create classes DeleteController and DeleteCommand and create file delete.html;
* Create class InitController which redirects to List;
* Update class Application with location of entities and repositories packages.
  

LAUNCH
------

To launch project please run following class: 
* Application.java

You can also launch project using Maven command:
* mvn spring-boot:run -Dspring.thymeleaf.cache=false


USAGE
-----

Link to main UI:
* http://[server]/app