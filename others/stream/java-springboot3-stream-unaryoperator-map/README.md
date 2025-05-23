DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use Functional Interface **UnaryOperator** with method **T apply(T)** together with **Stream** method **map()** in an application type **API REST** in **Java** programming language with usage **Spring Boot 3** framework. Method Stream.map() enables changing one object into another.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Maven**: tool for build automation
* **Git**: tool for distributed version control
* **API**: Application Programming Interface is designed for communication between machines
* **REST**: It's HTTP protocol with some set of rules
* **Functional Interface**: A functional interface in programming, particularly in Java, is an interface that contains exactly one abstract method. It can have multiple default or static methods, but only one method that is unimplemented. Functional interfaces are designed for use with lambda expressions and method references, enabling a more concise, functional-style coding. The most common example is the java.util.function package, which includes interfaces like Function, Predicate, and Consumer.


USAGE JAVA
----------

> Please be aware that following tools should be installed on your local PC: **Java**, **Maven** and **Git**. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In a command line tool start application with `mvn spring-boot:run`
1. In a browser visit `http://localhost:8080`
   * Expected JSON **{"message":"Hello World!"}**
1. Clean up environment 
     * In a command line tool stop application with `ctrl + C`