USAGE
-----

> **NOTE** This usage assumes that following tools are installed: **Java**, **Maven** and **Git**.

Steps:
1. In a command line tool start application with `mvn spring-boot:run`
1. In a browser start Server communication with `http://localhost:8080`
1. Clean up
     * In a command line tool stop application with `ctrl + c`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to **display** messages from Server using **Server-Send Events (SSE)** communication in **Java** application based on **Spring Boot** framework.

##### Terminology
Terminology explanation:
* **Java Spring Boot application**: it's application in Java programming language which uses Spring Boot framework. This is chat application - user can open two or more browsers or browser's tabs, register with specific name, send webRTC offer and then chat
* **Server-Send Events (SSE)**: it's a type of communication where Client initializes communication but then only Server sends messages. These messages are sent as Stream. Client can not send any message to Server.


##### Flow
The following flow takes place in this project:
1. User runs application
1. User via any browser sends request to Server for communication
1. Server sends back many reponses to User via browser
1. User cleans up

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
* Installed **Java** (tested on version 1.8.0_291)
* Installed **Maven** (tested on version 3.8.5)
* Installed **Git** (tested on version 2.33.0.windows.2)

##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder**