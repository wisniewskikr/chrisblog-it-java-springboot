DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to create remote automated test using JUnit 4 and Selenium tool in some example application.

#####Details
**Remote automated tests** mean that tested application has to be up and running before tests. Tests don't run application automatically. Automated tests will check if:
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
1. Start example application
2. Run Selenium automated tests
3. Stop example application

##### Ad 1\ Start example application
To start example application please open any **command line tool** on this project **root** folder and type following Maven command:
- **mvn spring-boot:run**

##### Ad 2\ Run Selenium automated tests
To run Selenium automated tests you have to just run Maven unit tests. So please open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean test**

##### Ad 3\ Stop example application
To stop example application please:
* Go to **opened command line tool** with example application;
* Click **Ctrl + C** to stop example application;
* Close all opened command line tools.