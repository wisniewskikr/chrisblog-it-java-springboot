USAGE
-----

> **NOTE** This usage assumes that following tools are installed: **Java**, **Maven** and **Git**.

Steps:
1. Start application with `mvn spring-boot:run`
1. Open first chat with `http://localhost:8080`
1. Open second chat with `http://localhost:8080`
1. Register two users and chat each other
1. Clean up
     * Stop application with `ctrl + c`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to create **Java Spring Boot** application which will send messages between **Java** and **Javascript** using **WebSockets**.

##### Terminology
Terminology explanation:
* **Java Spring Boot application**: it's application in Java programming language which uses Spring Boot framework. This is chat application - user can open two or more browsers or browser's tabs, register with specific name and then chat
* **Websockets**: WebSockets is a bidirectional, full-duplex, persistent connection between a web browser and a server or between servers. Once a WebSocket connection is established, the connection stays open until the client or server decides to close this connection.

> **Websockets vs Messages** Messages requires additional server - Message Server. Websocket doesn't require any additional server. It's just bidirectional connection between two actors.

##### Flow
The following flow takes place in this project:
1. User runs application
1. User via any browser sends request to broker for registration
1. Broker sends back to User via browser registration confirmation 
1. User via any browser sends request to broker with message
1. Broker sends back to User via browser the same message
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
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`

##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-java`)
