DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use **Optional** to **check null** and if exists **throw an exception** in an application type **API REST** in **Java** programming language with usage **Spring Boot 3** framework.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Maven**: tool for build automation
* **Git**: tool for distributed version control
* **API**: Application Programming Interface is designed for communication between machines
* **REST**: It's HTTP protocol with some set of rules


USAGE JAVA
----------

> Please be aware that following tools should be installed on your local PC: **Java**, **Maven** and **Git**. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In a command line tool start application with `mvn spring-boot:run`
1. In a browser visit `http://localhost:8080`
   * Expected exception with message: **Name cannot be null**
1. In a browser visit `http://localhost:8080?name=Stranger`
   * Expected JSON **{"message":"Hello World Stranger!"}**
1. Clean up environment 
     * In a command line tool stop application with `ctrl + C`