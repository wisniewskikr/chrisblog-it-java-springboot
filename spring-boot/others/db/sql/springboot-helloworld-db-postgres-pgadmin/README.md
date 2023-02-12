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
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* **Spring Boot**: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker**: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`
* **Docker Compose**: `https://docs.google.com/document/d/1SPrCS5OS_G0je_wmcLGrX8cFv7ZkQbb5uztNc9kElS4/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 17.0.5)
* Installed **Maven** (tested on version 3.8.5)
* Installed **Git** (tested on version 2.33.0.windows.2)
* Installed **Docker** (tested on version 20.10.21)
* Installed **Docker Compose** (tested on version v2.12.2)

##### Preconditions - Actions
* **Launched** Docker on your local machine
* **Download** source code using Git command `git clone https://github.com/wisniewskikr/chrisblog-it-java.git`
* Open any **Command Line** tool (for instance "Windonw PowerShell" on Windows OS) on **project's main folder**