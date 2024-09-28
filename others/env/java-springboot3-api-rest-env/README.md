DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use different **environment properties** in an application type **API REST** in **Java** programming language with usage **Spring Boot 3** framework.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Maven**: tool for build automation
* **Git**: tool for distributed version control
* **API**: Application Programming Interface is designed for communication between machines
* **REST**: It's HTTP protocol with some set of rules
* **Environment properties**: In Java, environment properties (or system properties) are key-value pairs that provide information about the runtime environment of the Java application. They include settings for system configurations such as the file system, user, and JVM settings. These properties are typically used for configuration or to retrieve details about the environment in which a Java program is running.


USAGE MANUAL
------------

> Please be aware that following tools should be installed on your local PC: **Java**, **Maven** and **Git**. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In a command line tool start application with `mvn spring-boot:run`
1. In a browser visit `http://localhost:8080`
   * Expected JSON **{"message":"Hello World from DEV!"}**
1. In a command line tool stop application with `ctrl + C`
1. In a command line tool start application with `mvn spring-boot:run "-Dspring-boot.run.profiles=prod"`
1. In a browser visit `http://localhost:8080`
   * Expected JSON **{"message":"Hello World from PROD!"}**
1. Clean up environment 
     * In a command line tool stop application with `ctrl + C`


USAGE DOCKER
------------

> Please be aware that following tools should be installed on your local PC: **Java**, **Maven**, **Git** and **Docker**. Docker tool has to **be up and running**. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In a command line tool build **Docker image for DEV** with `docker build -f Dockerfile-Dev -t hello-image:0.0.1 .`
1. In a command line tool build and start **Docker container for DEV** with `docker run -p 8080:8080 --name hello-container -d hello-image:0.0.1`
1. In a browser visit `http://localhost:8080`
   * Expected JSON **{"message":"Hello World from DEV!"}**
1. In a command line tool stop and remove **Docker container for DEV** with `docker rm -f hello-container`
1. In a command line tool remove **Docker image for DEV** with `docker rmi hello-image:0.0.1`
1. In a command line tool build **Docker image for PROD** with `docker build -f Dockerfile-Prod -t hello-image:0.0.1 .`
1. In a command line tool build and start **Docker container for PROD** with `docker run -p 8080:8080 --name hello-container -d hello-image:0.0.1`
1. In a browser visit `http://localhost:8080`
   * Expected JSON **{"message":"Hello World from PROD!"}**
1. Clean up environment 
     * In a command line tool stop and remove **Docker container for PROD** with `docker rm -f hello-container`
     * In a command line tool remove **Docker image for PROD** with `docker rmi hello-image:0.0.1`