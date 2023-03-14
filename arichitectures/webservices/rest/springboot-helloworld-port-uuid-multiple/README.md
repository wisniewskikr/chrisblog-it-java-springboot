DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to display **Hello World** message, **port FE**, **UUID FE**, **port BE** and **UUID BE** for **multiple** Java applications with **Spring Boot** framework. FE means Front-End application - application which is visible for user. BE means Back-End application - application which is not visible for user. UUID means unique id number for application.

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to FE application for a content
1. FE application sends request to BE application for a content
1. BE application sends back response with message, BE port and BE UUID to FE application
1. FE application sends back response with message, FE port, FE UUID, BE port and BE UUID to User via browser

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 11.0.16.1). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`


##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-java`)


USAGE
-----

Usage steps:
1. In the first Command Line tool start BE application with `mvn -f ./springboot-helloworld-port-uuid-multiple-be spring-boot:run`
1. In the second Command Line tool start BE application with `mvn -f ./springboot-helloworld-port-uuid-multiple-fe spring-boot:run`
1. Visit `http://localhost:8080`
1. Clean up environment:
    * In the first Command Line with `ctrl + C`
    * In the second Command Line with `ctrl + C`