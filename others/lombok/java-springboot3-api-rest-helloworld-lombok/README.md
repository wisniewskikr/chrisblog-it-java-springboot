EXAMPLE
-------

![My Image](readme-images/image-01.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use **Lombok** library in a **REST API** application with usage **Java** programming language and **Spring Boot 3** framework. Lombok library automatically reduces boilerplate code by generating commonly used methods.

##### Elements
This project consists of following elements:
* **App**: Rest API application
   * Input: endpoint "/"
   * Content: Lombok is used for automatically creating constructor in HelloWorldController
   * Output: JSON with message

##### Terminology
Terminology explanation:
* **Git**: Git is a distributed version control system (VCS) that tracks changes in code, allowing multiple developers to collaborate efficiently. It helps manage different versions of a project, enabling branching, merging, and rollback to previous states.
* **Maven**: Maven is a build automation and project management tool for Java-based projects, used primarily for dependency management and project configuration.
* **Java**: Java is a high-level, object-oriented programming language known for its platform independence, achieved through the Java Virtual Machine (JVM). It is widely used for web, mobile, and enterprise applications. Java follows the "write once, run anywhere" (WORA) principle, making it a popular choice for cross-platform development.
* **Spring Boot**: Spring Boot is a Java-based framework that simplifies the development of stand-alone, production-ready Spring applications by providing auto-configuration, embedded servers, and a convention-over-configuration approach.
* **REST API**: A REST API (Representational State Transfer API) is a web service that allows systems to communicate over HTTP using standard methods like GET, POST, PUT, and DELETE. It follows REST principles, ensuring scalability, statelessness, and resource-based interactions, typically using JSON or XML for data exchange.
* **Lombok**: Lombok is a Java library that automatically reduces boilerplate code by generating commonly used methods (e.g., getters, setters, constructors, equals, hashCode, toString) at compile time using annotations.


USAGES
------

This project can be tested in following configurations:
* **Usage Manual**: all services are started manually in a command line


USAGE MANUAL
------------

> Please be aware that following tools should be installed on your local PC: **Java**, **Maven** and **Git**. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In any command line tool start application with `mvn spring-boot:run`
1. In any browser visit `http://localhost:8080`
   * Expected JSON **{"message":"Hello World!"}**
1. Clean up environment 
     * In any command line tool stop application with `ctrl + C`