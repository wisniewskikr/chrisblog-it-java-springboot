USAGE
-----

> **Note** Please open project's main folder in your favorite command line tool and then run the commands below. Please be aware that to run this project tools **Java**, **Maven** and **Git** have to installed first. 

Usage steps:
1. Start application with `mvn spring-boot:run`
2. Visit `http://localhost:8080`
3. Clean up environment with `ctrl + C`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to create **reactive application** using **Java Spring Boot** framework with publisher type **Mono** from **WebFlux** dependency.

##### Terminology
Terminology explanation:
* **Java**: object programming language
* **Spring Boot**: Java framework which contains Spring framework, application server and configuration
* **Reactive programming**: asynchronous and non-blocking programming for stream of events. In classic programming result is sent once at the end. In reactive programming result is sent with small pieces
* **WebFlux**: dependency for reactive programming in Java Spring Boot
* **Mono**: publisher from WebFlux dependency which returns only one event

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application for a content.
1. Application HelloWorld returns response with JSON containing message, port and UUID. This response is presented to User via browser.

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
* **Launch** Docker tool on your local machine
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-java-springboot`)