DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create inner automated test using JUnit4 and Selenium tool in some example application.

#####Details
**Inner automated tests** mean that tested application will be started during tests. It doesn't have to be up and running in advance. Tests will start this application automatically. Automated tests will check if:
* tested elements are visible on pages;
* actions on tested pages finish with expected results. 

**Example application** is Spring Boot application with a web layer handled by Thymeleaf technology. It consists of two pages: 
* Input: where name can be typed;
* Output: where "Hello World + name" message is displayed.

#####Technologies
Used technologies:
* Java
* Maven
* Git
* Spring Boot
* Selenium


USAGE
-----

Usage steps:
1. Run Selenium automated tests

##### Ad 1\ Run Selenium automated tests
To run Selenium automated tests you have to just run Maven unit tests. So please open any **command line tool** on this project **root** folder and type following Maven command:
- **mvn clean test**