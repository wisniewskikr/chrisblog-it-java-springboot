WIP
---

This project is still **Work In Progress** because for some reason configuration **SPRING_KAFKA_CONSUMER_AUTO_OFFSET_RESET** is not handled.


DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to send JMS messages from one Spring Boot application (Producer) to other (Consumer) using Apache Kafka JMS broker (type Wurstmeister). All applications are on different Docker Containers. All Docker Containers are run by Docker Compose.

Additionally this project shows how **auto-offset-reset** works. It configures direction of not handled events for new Customer:
- **latest** (default): from the latest to the first;
- **earliest**: from the earliest to the end.

In this example we have two Consumers which should be created after events are sent. One of consumers has configuration "latest" and second "earliest".

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
6. Clean up

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
To read messages please check logs of Consumer application. Following messages should be displayed in declared reset order: **Hello World {name}** . For instance:
- Hello World Chris
- Hello World Waclaw
- Hello World Milena

##### Ad 6\ Clean up
To clean up applications please in command line press **ctrl + C** and then type:
- **docker-compose -f docker-compose-consumer.yml down**
- **docker-compose down**