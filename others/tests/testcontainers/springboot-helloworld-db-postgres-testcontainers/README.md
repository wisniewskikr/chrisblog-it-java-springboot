USAGE
-----

> **NOTE:** Tools **Git**, **Java** and **Maven**. Please open Command Line tool on **main folder of project**.

Usage steps:
1. In command line tool run integration test with `mvn test -Dtest="HelloWorldControllerIT"`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to create **Integration Test** with **Test Containers** for application in **Java** programming language with usage **Spring Boot** framework. This application uses database type **Postgres**.

##### Terminology
Terminology explanation:
* **Java Spring Boot application**: application created in Java programming language with usage Spring Boot framework
* **Integration Tests**: these tests validate integration between diferent part of systems. They check if everything together works fine
* **Test Containers**: this library enables to run some Docker container before tests. For instance Docker container with database can be run before tests
* **Postgres**: relational database

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application HelloWorld for content
1. Application HelloWorld saves text "Hello World" to database and then read it
1. Application HelloWorld returns response with message. This response is presented to User via browser

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* **Spring Boot**: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 17.0.5)
* Installed **Maven** (tested on version 3.8.5)
* Installed **Git** (tested on version 2.33.0.windows.2)

##### Preconditions - Actions
* **Launched** Docker on your local machine
* **Download** source code using Git
* Open any **Command Line** tool (for instance "Windonw PowerShell" on Windows OS) on **project's main folder**