DESCRIPTION
-----------

#####Goal
The goal of this project is to explain how to run only part of JUnit 4 and Selenium tests in Java Spring Boot project. Run only part means that developer can flexible configure - by Maven profiles and parameters - which exactly tests should be run:
* **classes or classes with methods**: developer can run single test class/classes or even single method/methods.

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
1. Start example application
2. Run all Selenium automated tests
3. Run only "auto-test" profile
4. Run Selenium single test class
5. Run Selenium specified tests classes
6. Run Selenium single test method
7. Run Selenium specified tests methods
8. Stop example application

##### Ad 1\ Start example application
To start example application please open any **command line tool** on this project **root** folder and type following Maven command:
- **mvn spring-boot:run**

##### Ad 2\ Run all Selenium automated tests
To run all Selenium automated tests you have to just run Maven unit tests. So please open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean test**

Expected result is that all tests will be run.

##### Ad 3\ Run only "auto-test" profile
To run "auto-test" profile you have to use Maven command. So please **use previous** or open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean install -Pauto-tests**

Expected result is that all tests will be run.

##### Ad 4\ Run Selenium single test class
To run Selenium single test class you have to just run Maven unit tests with profile and parameter. So please **use previous** or open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean install -Pauto-tests -Dpart=InputTest**

Expected result is that only tests from class InputTest will be run.

##### Ad 5\ Run Selenium specified tests classes
To run Selenium specified tests classes you have to just run Maven unit tests with profile and parameter. So please **use previous** or open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean install -Pauto-tests -Dpart=InputTest,OutputTest**

Expected result is that only tests from class InputTest will be run.

##### Ad 6\ Run Selenium single test method
To run Selenium single test method you have to just run Maven unit tests with profile and parameter. So please **use previous** or open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean install -Pauto-tests -Dpart=InputTest.test01**

Expected result is that only method test01() from class InputTest will be run. Other methods will be skipped.

##### Ad 7\ Run Selenium specified tests methods
To run Selenium specified tests methods you have to just run Maven unit tests with profile and parameter. So please **use previous** or open **NEW command line tool** on this project **root** folder and type following Maven command:
- **mvn clean install -Pauto-tests -Dpart=InputTest.test01,OutputTest.test01**

Expected result is that methods test01() from classes InputTest and OutputTests will be run. Other methods will be skipped.

##### Ad 8\ Stop example application
To stop example application please:
* Go to **opened command line tool** with example application;
* Click **Ctrl + C** to stop example application;
* Close all opened command line tools.