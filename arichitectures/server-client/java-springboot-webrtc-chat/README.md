USAGE
-----

> **NOTE** This usage assumes that following tools are installed: **Java**, **Maven** and **Git**.

Steps:
1. In a command line tool start application with `mvn spring-boot:run`
1. In a browser open first chat with `http://localhost:8080`
1. In a browser open second chat with `http://localhost:8080`
1. In a browser register two users
1. In a browser send offer for two users
1. In a browser chat between two users
1. Clean up
     * In a command line tool stop application with `ctrl + c`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to create **chat** using **webRTC** protocol in **Java** application based on **Spring Boot** framework.

##### Terminology
Terminology explanation:
* **Java Spring Boot application**: it's application in Java programming language which uses Spring Boot framework. This is chat application - user can open two or more browsers or browser's tabs, register with specific name, send webRTC offer and then chat
* **webRTC**: it's protocol for chats, audio or video. It users peer-to-peer connection - direct connection between two clients. Server called Signal Server is required only to establish this P2P connection - offer, answer and candidates are exchanged between two clients. Later all communication is done through P2P directly between two clients
* **Websockets**: WebSockets is a bidirectional, full-duplex, persistent connection between a web browser and a server or between servers. In this example this connection is used only on the beginning to contact with Signal Server. Later all communication is done through P2P


##### Flow
The following flow takes place in this project:
1. User runs application
1. User via any browser sends request to Server for registration
1. Server sends back response to User via browser registration confirmation 
1. User via browser sends offer to Server. This offer is redirected to other client
1. Server sends back response with answer to User via browser
1. User via any browser sends request to another Client with message
1. Client sends back response to User via browser with anser
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