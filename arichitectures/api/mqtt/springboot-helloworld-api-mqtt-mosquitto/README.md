USAGE
-----

> This usage assumes that you have installed on your local machine following tools: **Java**, **Maven**, **Git**, **Docker** and **Docker Compose**. Tools Docker and Docker Compose have to be **up and running**.

Usage steps:
1. In a command line tool start Mosquitto with `docker-compose up -d`
1. In a command line tool start application with `mvn spring-boot:run`
1. In a Postman tool run GET method for uri `http://localhost:8080`
     * In a Postan tool expected sentence: **Success**
     * In a command line tool expected sentence: **This is the topic: myTopic**
     * In a command line tool expected sentence: **Hello World!**
1. Clean up environment 
     * In a command line tool stop application with `ctrl + C`
     * In a command line tool stop Mosquitto with `docker-compose down`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement communication **API** type **MQTT** in Java application with usage **Spring Boot** framework and MQTT broker **Mosquitto**.

Broker Mosquitto is started by **Docker Compose** tool.

##### Terminology
Terminology explanation:
* **Java Spring Boot application**: application created in Java programming language with usage Spring Boot framework
* **MQTT**: is a communication protocol designed specifically for IoT (Internet of Things - on other words for devices)
* **Mosquitto**: is a broker for publish-subscribe messages. It uses MQTT communication. It simulates IoT
* **Docker**: platform for deploying application in closed units called Docker Containers
* **Docker Compose**: tool for working with many Docker Containers

##### Flow
The following flow takes place in this project:
1. User via Postman sends request to application.
1. Application sends message to Publisher.
1. Publisher publishes message on Mosquitto broker.
1. Subscriber receives message from Mosquitto broker.

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
* **Run** Docker tool on local machine
* **Run** Docker Compose tool on local machine
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on the main **project's folder**.