DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to configure Topic Partition for Consumer in Kafka environment. Kafka environment enables sending JMS messages from one Spring Boot application (Producer) to other (Consumer) using Apache Kafka JMS broker (type Wurstmeister). All applications are on different Docker Containers. All Docker Containers are run by Docker Compose.

Configuration of Topic Partition for Consumer shows which Partition of Topic should be consumed by this specific method. So one Consumer can have many methods which will consume different partitions.

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
2. Start elements using Docker Compose
3. Send message
4. Read message
5. Clean up

##### Ad 1\ Build packages
To build packages please open command line console on root folder of this project and type following command:
- **mvn clean package**

##### Ad 2\ Start elements using Docker Compose

To start elements please open command line console on root folder of this project and type following command:
- **docker-compose up --build**

##### Ad 3\ Send messages
To send message by Producer please use in browser following URL:
- **http://localhost:8080/greeting/partition/{partition}/timestamp/{timestamp}/key/{key}/value/{value}** 

In this example please send messages for partitions **0** and **1**. For instance:
- http://localhost:8080/greeting/partition/0/timestamp/null/key/greeting/value/Chris
- http://localhost:8080/greeting/partition/1/timestamp/null/key/greeting/value/Chris

If everything is ok then message **Done** should be displayed in browser.

##### Ad 4\ Read messages
To read the message please check logs of Consumer application. Following message should be displayed: **Hello World {name}** . 

In this example different Consumer listeners should be run for different partitions. So following messages should be displayed:
consumer   | greetingListenerForPartition0()
consumer   | Key: greeting
consumer   | Partition: 0
consumer   | Timestamp: 1645513918026
consumer   | Message: Hello World Chris
consumer   | greetingListenerForPartition1()
consumer   | Key: greeting
consumer   | Partition: 1
consumer   | Timestamp: 1645513925873
consumer   | Message: Hello World Chris

##### Ad 5\ Clean up
To clean up applications please in command line press **ctrl + C** and then type **docker-compose down**