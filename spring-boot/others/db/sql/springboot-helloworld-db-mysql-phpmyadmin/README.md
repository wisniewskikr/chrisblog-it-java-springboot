USAGE
-----

> **NOTE:** Tools **Java**, **Maven**, **Docker** and **Docker Compose** have to be installed. Tool **Docker** has to be up and running. Please open Command Line tool on **main folder of project**.

Usage steps:
1. Start database and console with `docker-compose up -d`
1. (Optional) Check database and console status with `docker ps -a`
1. Start application with `mvn spring-boot:run`
1. Visit `http://localhost:8080`
1. (Optional) Check database in console (server: "mysql", username: "admin", password: "admin123") with `http://localhost:8081`
1. Clean up local environment 
     * Stop application `ctrl + C`
     * Stop database and console with `docker-compose down`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to create **Hello World** application in **Java** programming language with usage **Spring Boot** framework. This application uses database type **MySql**. Additionally tool **PhpMyAdmin** will be set up - it's console for MySql database.

Tools MySql and PhpMyAdmin are set up by Docker Compose tool.

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


PRECONDITIONS
-------------
##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`

##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-java`)