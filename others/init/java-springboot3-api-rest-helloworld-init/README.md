DESCRIPTION
-----------

##### Goal
The goal of this project is to present - step by step - how to init application based on **Java** programming language and **Spring Boot** framework. This application is created by **Spring Initializr**, then opened in **Visual Studio Code** IDE and at the end added to **GitHub** repository. 

##### Terminology
Terminology explanation:
* **Git**: tool for distributed version control
* **Maven**: tool for build automation
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Spring Initializr**: it is an online tool provided by the Spring framework that helps developers quickly generate the foundational setup for new Spring Boot projects. It allows users to select project settings, such as build tool (Maven or Gradle), Spring Boot version, dependencies, and Java version, then generates a ready-to-use project structure with a ZIP file download. This accelerates the process of starting a Spring Boot application by automating the setup of key configurations and dependencies.
**Visual Studio Code (VS Code)**: it is a lightweight, open-source code editor developed by Microsoft. It supports multiple programming languages, offers built-in Git integration, and features an extensive marketplace for extensions. Key features include syntax highlighting, code completion (with IntelliSense), debugging tools, and a customizable user interface. It is cross-platform, running on Windows, macOS, and Linux.


EXAMPLE
-------

![My Image](readme-images/image-01.png)

![My Image](readme-images/image-02.png)


USAGE MANUAL
------------

> **Usage Manual** means that Back-End and Front-End services are provided as **Java and Maven applications** and started **manually**. Tool **Hey** is provided as **Docker container**.

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

> Please be aware that following tools should be installed on your local PC:  
* **Operating System** (tested on Windows 11)
* **Java** (tested on version 17.0.5)
* **Maven** (tested on version 3.8.5)
* **Git** (tested on version 2.33.0.windows.2)
* **Docker** (texted on version 4.33.1 - it has to be up and running)

##### Required steps:
1. In the first command line tool **start Back-End application** with `mvn -f ./fe-springboot-be-springboot-threads-no_BE spring-boot:run`
1. In the second command line tool **start Front-End application** with `mvn -f ./fe-springboot-be-springboot-threads-no_FE spring-boot:run`
1. In the third command line tool **run Docker Hey image** for testing 30 threads with `docker run --rm williamyeh/hey -n 30 -c 30 http://host.docker.internal:8080/`
   * Expected **Summary -> Total** with value **over 9 seconds** (test for 30 threads -> FE restricted to 10 threads -> BE API call restricted to at least 3 seconds)
1. Clean up environment:
     * In the third command line tool **remove Docker Hey image** with `docker rmi williamyeh/hey`
     * In the second command line tool **stop Front-End application** with `ctrl + C`
     * In the first command line tool **stop Back-End application** with `ctrl + C`
     

##### Optional steps:
1. In a browser check Back-End application healthcheck with `http://localhost:8081/actuator/health`
1. In a browser check Back-End application API result with `http://localhost:8081/`
1. In a browser check Front-End application healthcheck with `http://localhost:8080/actuator/health`
1. In a browser check Front-End application API result with `http://localhost:8080/`
1. In a command line tool check list of Docker images with `docker images`
1. In a command line tool check list of all Docker containers with `docker ps -a`
1. In a command line tool check list of active Docker containers with `docker ps`