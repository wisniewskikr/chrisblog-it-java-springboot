DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use 'actuator' dependency in simple "Hello World" Java Spring Boot application.

##### Details
Details:
* This example application displays text: "Hello World"
* Dependency 'actuator' displays health status of current application


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed Java
* Installed Maven
* Installed Git

##### Preconditions - Actions
* Download Source Code with `git clone https://github.com/wisniewskikr/java-springboot.git`


USAGE
-----

Usage steps:
1. Start application with `mvn spring-boot:run`
2. Visit `http://localhost:8080`
3. Check health status - expected result is **{"status":"UP"}**. Visit `http://localhost:8080/actuator/health`
4. Clean up environment with `ctrl + C`