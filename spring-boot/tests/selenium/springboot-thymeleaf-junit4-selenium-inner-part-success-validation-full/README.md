DESCRIPTION
-----------

#####Goal
The goal of this project is to explain how to run only part of JUnit 4 and Selenium tests in Java Spring Boot project. Run only part means that developer can flexible configure - by Maven profiles and parameters - which exactly tests should be run:
* **full**: all tests;
* **success**: only test classes with word "Success" in the name. For instance "InputSuccessTest". It's useful when developer wants to fast check if application works ok. No sophisticated validation tests are run here;
* **validation**: only test classes with word "Validation" in the name. For instance "InputValidationTest". These classes can have time consuming sophisticated validation methods;
* **classes or classes with methods**: developer can also run single test class or method.

Precondition of such approach is that every single test is closed unit - single test doesn't need anything from test before or after. All necessary configuration is in this test.

#####Details
**JUnit** is Java library which enables unit tests of application.

**Selenium** is tool which enables read data from browsers.

**Maven profile** enables to run different Maven actions regarding to specific profile. User can activate or deactivate these profiles in command line.

**Spring Boot** application is Java application based on framework Spring Boot. In this example application consists of two pages: 
* Input: where name can be typed;
* Output: where "Hello World + name" message is displayed.

#####Technologies
Used technologies:
* Java
* Maven
* Git
* Spring Boot
* JUnit
* Selenium


USAGE
-----

Usage steps:
1. Run profile "full"
2. Run profile "success"
3. Run profile "validation"

##### Ad 1\ Run profile "full"
To run this profile please open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean install -Pauto-tests -Dpart=full**

Expected result: all test classes - InputSuccessTest and InputValidationTest - should be run.

##### Ad 2\ Run profile "success"
To run this profile please open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean install -Pauto-tests -Dpart=success**

Expected result: only test class InputSuccessTest should be run.

##### Ad 3\ Run profile "validation"
To run this profile please open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean install -Pauto-tests -Dpart=validation**

Expected result: only test class InputValidationTest should be run.