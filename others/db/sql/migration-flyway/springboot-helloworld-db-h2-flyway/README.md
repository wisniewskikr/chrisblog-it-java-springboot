USAGE
-----

Usage steps:
1. In command line tool start application with `mvn spring-boot:run`
1. In Postman tool using GET method visit `http://localhost:8080`
1. (Optional) Check database in console (url: "jdbc:h2:mem:db-embedded", user: "admin", password: "admin123") with `http://localhost:8080/console`
1. Clean up environment with `ctrl + C`


USAGE PRINTSCREENS
------------------

![My Image](images/image-01.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use database migration tool **Liquibase** in **Java** application with usage **Spring Boot** framework and **embedded** database type **h2**.

##### Terminology
Terminology explanation:
* **Java Spring Boot application**: application created in Java programming language with usage Spring Boot framework
* **Liquibase**: this tool enables automated database migration. All database migration scrips are loaded before application is started
* **H2**: relational database
* **Embedded database**: it means that database is started together with application 

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application HelloWorld for content
1. Application HelloWorld saves text "Hello World" to database and then read it
1. Application HelloWorld returns response with message. This response is presented to User via browser

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`


PRECONDITIONS
-------------
##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 11)
* Installed **Java** (tested on version 17.0.5)
* Installed **Maven** (tested on version 3.8.5)
* Installed **Git** (tested on version 2.33.0.windows.2)

##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on the main **project's folder**.