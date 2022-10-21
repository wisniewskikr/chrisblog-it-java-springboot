WIP
---

This project is still **Work In Progress** because for some reason configuration **SPRING_KAFKA_CONSUMER_ENABLE_AUTO_COMMIT** is not handled.


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to send JMS messages from one Spring Boot application (Producer) to other (Consumer) using Apache Kafka JMS broker (type Wurstmeister). All applications are on different Docker Containers. All Docker Containers are run by Docker Compose.

Additionally this project shows how the property **enable-auto-commit** works. It configures auto commit for Consumer. If value is:
* **true**: it means that Consumer should inform Kafka which events were consumed. Additionally you can use here property **auto-commit-interval-ms** which configures how often in milliseconds Kafka should be informed;
* **false**: it means that Consumer should not inform Kafka which events were consumed.

In this example we have two Consumers which should be created after events are sent. One of consumers has configuration "true" and second "false".

Link to **Kafka** theory documentation: https://docs.google.com/document/d/1pDBnFbpvo0mNaIgxLCV--3qUn-wf0vHZiTYRQL05Wes/edit?usp=sharing

#####Details
This project consists of:
* **Apache Kafka server**: JMS broker - tool which enable sending and receiving JMS messages
* **Spring Boot Producer application**: application which sends messages to Apache Kafka
* **Spring Boot Consumer application**: application which receives messages from Apacke Kafka

#####Technologies
Used technologies:
* Java
* Maven
* Git
* Spring Boot
* Docker Compose
* Apache Kafka


USAGE
-----

Usage steps:
1. Build packages
2. Start elements without Consumer using Docker Compose
3. Send messages
4. Start Consumers using Docker Compose
5. Read messages
6. Stop Consumers using Docker Compose
7. Start again Consumers using Docker Compose
8. Read again messages
9. Clean up

##### Ad 1\ Build packages
To build packages please open command line console on root folder of this project and type following command:
- **mvn clean package**

##### Ad 2\ Start elements without Consumer using Docker Compose

To start elements please open command line console on root folder of this project and type following command:
- **docker-compose up -d --build**

##### Ad 3\ Send messages
To send message by Producer please use in browser following URL:
- **http://localhost:8080/greeting/name/{name}** 

In this example you should send many messages to check reset order. For instance: 
- http://localhost:8080/greeting/name/Chris
- http://localhost:8080/greeting/name/Waclaw
- http://localhost:8080/greeting/name/Milena

If everything is ok then message **Done** should be displayed in browser.

##### Ad 4\ Start Consumers using Docker Compose

To start Consumers please open command line console on root folder of this project and type following command:
- **docker-compose -f docker-compose-consumer.yml up --build**

##### Ad 5\ Read messages
To read messages please check logs of Consumer application. For instance:
- Hello World Chris
- Hello World Waclaw
- Hello World Milena

##### Ad 6\ Stop Consumers using Docker Compose
To stop consumers please in command line press **ctrl + C** and then type:
- **docker-compose -f docker-compose-consumer.yml down**

##### Ad 7\ Start again Consumers using Docker Compose

To start Consumers please open command line console on root folder of this project and type following command:
- **docker-compose -f docker-compose-consumer.yml up --build**

##### Ad 8\ Read again messages
To read messages please check logs of Consumer application. For Consumer with property **enable-auto-commit** set as **false** messages should be read once again. For instance:
- Hello World Chris
- Hello World Waclaw
- Hello World Milena

##### Ad 9\ Clean up
To clean up applications please in command line press **ctrl + C** and then type:
- **docker-compose -f docker-compose-consumer.yml down**
- **docker-compose down**