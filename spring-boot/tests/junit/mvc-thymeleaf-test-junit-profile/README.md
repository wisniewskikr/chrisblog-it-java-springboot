DESCRIPTION
-----------

#####Goal
The goal of this project is to explain what JUnit and Maven profile is and how to configure it in Java Spring Boot project.

#####Details
**JUnit** is Java library which enables unit tests of application.

**Maven profile** enables to run different Maven actions regarding to specific profile. User can activate or deactivate these profiles in command line.

**Spring Boot** application is Java application based on framework Spring Boot. In this example application has only one page which displays text: **Hello World!!**.

#####Technologies
Used technologies:
* Java
* Maven
* Git
* Spring Boot
* JUnit


USAGE
-----

Usage steps:
1. Run default Maven "test" command
2. Run Maven with profile

##### Ad 1\ Run default Maven "test" command
In this step default JUnit tests should be run. Profile will be ignored.

To run it please open any **command line console on the root folder of this project** and type following command:
- **mvn clean test**

In console you should see that one JUnit test is run and pass.

##### Ad 2\ Run Maven with profile
In this step default JUnit tests should be ignored. Only tests from profile should be run.

To run it please ** use previous one** or open any **command line console on the root folder of this project** and type following command:
- **mvn clean test -Prun-profile-tests**

In console you should see that one JUnit test is run and pass.
