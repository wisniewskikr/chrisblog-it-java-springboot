DESCRIPTION
-----------

##### Goal
The goal of this project is to show how to **send JMS message** type **Queue** from one **Java** application with **Spring Boot** framework (called **Producer**) to other (called **Consumer**) using **Rabbit MQ** JMS broker. All applications are on different Docker containers managed by **Docker Compose** tool.

##### Details
This project consists of:
* **Rabbit MQ server**: JMS broker - tool which enable sending and receiving JMS messages. In this example event type **Queue** is sent - it means that one Producer can send message to only one Customer
* **Spring Boot Producer application**: application which sends messages to Rabbit MQ. Two types of messages can be sent here - accessible manually by APi or accessible automatically by Listener in Consumer application. Message is sent by **browser** using specific URL with **name** as parameter
* **Spring Boot Consumer application**: application which receives messages from Rabbit MQ. Two types of message are read here - accessible manually by API or accessible automatically by Listener. Messages are consumed in two ways - by **browser** and by **console**. To consume message by browser user has to use specific URL. To consume message by console user does not have to do anything - it's done automatically. Both consuming method displays: **Hello World + {name}**

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker Compose** tool: `https://docs.google.com/document/d/1SPrCS5OS_G0je_wmcLGrX8cFv7ZkQbb5uztNc9kElS4/edit?usp=sharing`
* **Rabbit MQ** tool: `https://docs.google.com/document/d/15Bt-EwpDhFrC6bZ5Hn3L2xJLqkxdMQKVSWflN095OVA/edit?usp=sharing`

PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* Installed **Docker** (tested on version version 20.10.12). Tool details: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`

##### Preconditions - Actions
* **Launch** Docker tool
* **Download** source code and open any **Command Line** tool on **project's folder**. You can do it in following way:
    * Open any Command Line tool (for instance "Windonw PowerShell" on Windows OS) and go to folder where you want to download source code 
    * Clone Github repository with `git clone https://github.com/wisniewskikr/chrisblog-it.git`
    * Go to source code folder with `cd chrisblog-it\java-messages-rabbitmq\springboot-rabbitmq-queue-docker-compose`


USAGE
-----

Usage steps:
1. Build packages with `mvn clean package`
1. Start elements using Docker Compose with `docker-compose up --build`
1. Send manual message (expected text **Done** in the browser) with **http://localhost:8080/helloworld/type/api/name/{name}**. For instance: `http://localhost:8080/helloworld/type/api/name/Chris`
1. Read manual message. Read message (expected **Hello World {name}**, for instance: Hello World Chris.) with `http://localhost:9090/helloworld/type/api/message`
1. Send automatic message (expected text **Done** in the browser) with **http://localhost:8080/helloworld/type/listener/name/{name}**. For instance: `http://localhost:8080/helloworld/type/listener/name/Chris`
1. Read automatic message. Check logs in Command Line tool where message **Hello World {name}** should be displayed. For instance: Hello World Chris.
1. Clean up environment
    * Stop containers with `ctrl + C`
    * Remove containers `docker-compose down`