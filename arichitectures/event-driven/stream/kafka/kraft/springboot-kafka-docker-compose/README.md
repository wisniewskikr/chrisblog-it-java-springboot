DESCRIPTION
-----------

##### Goal
The goal of this project is to show how to **send JMS messages** from one **Java** application with **Spring Boot** framework (called **Producer**) to other (called **Consumer**) using **Apache Kafka** JMS broker (type **Wurstmeister**). All applications are on different Docker containers managed by **Docker Compose** tool.

##### Details
This project consists of:
* **Apache Kafka server**: JMS broker - tool which enable sending and receiving JMS messages
* **Spring Boot Producer application**: application which sends messages to Apache Kafka. User's **name** is sent as parameter
* **Spring Boot Consumer application**: application which receives messages from Apacke Kafka and displays it on Console. Following message is displayed: **Hello World + {name}**

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker Compose** tool: `https://docs.google.com/document/d/1SPrCS5OS_G0je_wmcLGrX8cFv7ZkQbb5uztNc9kElS4/edit?usp=sharing`
* **Apache Kafka** tool: `https://docs.google.com/document/d/1pDBnFbpvo0mNaIgxLCV--3qUn-wf0vHZiTYRQL05Wes/edit?usp=sharing`

PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* Installed **Docker** (tested on version version 20.10.12). Tool details: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`

##### Preconditions - Actions
* **Download** source code and open any **Command Line** tool on **project's folder**. You can do it in following way:
    * Open any Command Line tool (for instance "Windonw PowerShell" on Windows OS) and go to folder where you want to download source code 
    * Clone Github repository with `git clone https://github.com/wisniewskikr/chrisblog-it.git`
    * Go to source code folder with `cd chrisblog-it\java-messages-kafka\springboot-kafka-wurstmeister-docker-compose`


USAGE
-----

Usage steps:
1. Build packages with `mvn clean package`
2. Start elements using Docker Compose with `docker-compose up --build`
3. Send message (expected text **Done** in the browser) with **http://localhost:8080/helloworld/name/{name}**. For instance: `http://localhost:8080/helloworld/name/Chris`
4. Read message by checking logs in Command Line tool. The application **Consumer** should display following message there: **Hello World {name}**. For instance: Hello World Chris.
5. Clean up environment
    * Stop containers with `ctrl + C`
    * Remove containers `docker-compose down`
