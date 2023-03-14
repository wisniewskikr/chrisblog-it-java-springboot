DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to send JMS messages from one Spring Boot application (Producer) to other (Consumer) using Apache Kafka JMS broker (type Wurstmeister). All applications are on different Docker Containers. All Docker Containers are run by Docker Compose.

Additionally this project shows how to **configure many Procuders**. Producer is application which create events. Many Producers can create events related to the same topic. In this example there are two Producers definied on ports **8080** and **8081**. Producer instances are definied in file **docker-compose.yml**.

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
- **http://localhost:8081/greeting/name/{name}**

For instance: 
- http://localhost:8080/greeting/name/Chris
- http://localhost:8081/greeting/name/Chris


If everything is ok then message **Done** should be displayed in browser.

##### Ad 4\ Read message
To read the message please check logs of Consumer application. Following message should be displayed there: **Hello World {name}**. For instance: Hello World Chris.

##### Ad 5\ Clean up
To clean up applications please in command line press **ctrl + C** and then type **docker-compose down**