DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to send JMS messages from one Spring Boot application (Producer) to other (Consumer) using Apache Kafka JMS broker (type Wurstmeister). All applications are on different Docker Containers. All Docker Containers are run by Docker Compose.

Additionally this project shows how to **configure many Consumers**. Consumer is an application which consume events. Many Consumers can consume events related to the same Topic or to different Topics. In this example there are two Consumers definied on ports **9090** with group **mygroup1** and **9091** with group **mygroup2**. Because we have two groups so every event is consumed by these two Consumer separately. Consumers instances are definied in file **docker-compose.yml**.

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

##### Ad 3\ Send message
To send message by Producer please use in browser following URL:
- **http://localhost:8080/greeting/name/{name}** 

For instance: 
- http://localhost:8080/greeting/name/Chris

If everything is ok then message **Done** should be displayed in browser.

##### Ad 4\ Read message
To read the message please check logs of Consumer application. Following message should be displayed twice - one for every Consumer: **Hello World {name}** . For instance: Hello World Chris.

##### Ad 5\ Clean up
To clean up applications please in command line press **ctrl + C** and then type **docker-compose down**