USAGE
-----

> This usage assumes that you have installed on your local machine following tools: **Java**, **Maven**, **Git**, **Docker** and **Docker Compose**.

Usage steps:
1. In command line tool start Redis with `docker-compose up -d`
1. In command line tool start application with `mvn spring-boot:run`
1. In Postman tool send message using GET method with `http://localhost:8080`
1. In console check result:
     * Expected Publisher message: **Publish message Hello World! on channel helloworld**
     * Expected Subscriber message: **Subscribe message Hello World! on channel helloworld**
1. Clean up environment 
     * Stop application with `ctrl + C`
     * Stop Redis with `docker-compose down`

DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **publish - subscribe** operations on **Redis** tool in **Java** application type **API REST** with usage **Spring Boot** framework.

Tools Redis is started by **Docker Compose** tool.

##### Terminology
Terminology explanation:
* **Java Spring Boot application**: application created in Java programming language and basing on Spring Boot framework.
* **Publish - Subcribe operations**: asynchronous operations between Publishers and Subscribers. Pubslishers send messages to Broker. Subscribers receives messages from from Broker. This operations are asynchronous - they can be done in diffrent time frames.
* **Redis**: tool which can be used as noSQL database or Publish-Subscribe broker
* **Docker**: platform for deploying application in closed units called Docker Containers
* **Docker Compose**: tool for working with many Docker Containers

##### Flow
The following flow takes place in this project:
1. User via Postman sends request to application.
1. Application sends message to Publisher.
1. Publisher publishes message on Redis broker.
1. Subscriber receives message from Redis broker.

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
* Installed **Docker** (tested on version 4.17.0)
* Installed **Docker Compose** (tested on version 2.15.1)


##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on the main **project's folder**.