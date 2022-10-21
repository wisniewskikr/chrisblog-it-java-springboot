DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to configure and run **remote automated tests** for Spring Boot application with Thymeleaf template located on **different environments**. Automated tests are based on JUnit 4 and Selenium technologies. 

Automated tests of type **remote** means that we assume that tested application is already up and running. Automated tests just check existing application. 

Automated tests for **different environments** means that in Maven command line we can choose which environment should be tested now. In this example we can run automated tests for following environments:
* **DEV**: application on port 8080
* **PROD**: application on port 9090 

#####Details
This example Spring Boot application consists of two pages:
* **Input**: form with text field for name and submit button;
* **Output**: text "Hello World" + name is displayed here.

#####Technologies
Used technologies:
* Java
* Maven
* Git
* Spring Boot
* JUnit 4
* Selenium


USAGE
-----

Usage steps:
1. Start DEV Spring Boot application 
2. Start PROD Spring Boot application
3. Run automated tests for DEV
4. Run automated tests for PROD
5. Clean up

##### Ad 1\ Start DEV Spring Boot application
Please open **new** command line console on **root** folder of this project and type following command:
- **mvn spring-boot:run -Dspring-boot.run.profiles=dev**

##### Ad 2\ Start PROD Spring Boot application
Please open **new** command line console on **root** folder of this project and type following command:
- **mvn spring-boot:run -Dspring-boot.run.profiles=prod**

##### Ad 3\ Run automated tests for DEV
Please open **new** command line console on **root** folder of this project and type following command:
- **mvn clean install -Pauto-tests-dev**

Expected result: Automated tests should be run for DEV environment: port 8080.

##### Ad 4\ Run automated tests for PROD
Please use **previous** command line console on **root** folder of this project and type following command:
- **mvn clean install -Pauto-tests-prod**

Expected result: Automated tests should be run for PROD environment: port 9090.

##### Ad 5\ Clean up
To clean up:
* Go command line console from Step 1 and press **CTRL + C** and then close this console;
* Go command line console from Step 2 and press **CTRL + C** and then close this console;
* Go command line console from Steps 3 and 4 and close this console.