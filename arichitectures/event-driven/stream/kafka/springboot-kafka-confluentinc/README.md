DESCRIPTION
-----------

#####Goal
The goal of this project is to show how to send JMS messages from one Spring Boot application (Producer) to other (Consumer) using Apache Kafka JMS broker (type Confluentinc). All applications are on the same machine - localhost.

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


URLS
----

* **Producer API**: http://localhost:8080/greeting/name/{name} . For instance: http://localhost:8080/greeting/name/Chris


USAGE
-----

Usage steps:
1. Start Kafka Server (docker compose)
2. Start Spring Boot Kafka Producer application
3. Start Spring Boot Kafka Consumer application
4. Send message
5. Read message
6. Clean up

##### Ad 1\ Start Kafka Server (docker compose)

To start Kafka Server the tool **docker compose** is required. Steps:
- Open command line on folder **springboot-kafka-server**
- Run following command there: **docker-compose up**

##### Ad 2\ Start Spring Boot Kafka Producer application

You can start this application in two ways:
- **Option 1**: open command line on folder **springboot-kafka-producer** and run following Maven command: **mvn spring-boot:run**
- **Option 2**: in application **springboot-kafka-producer** open class **Application.java** and run method **main()**

##### Ad 3\ Start Spring Boot Kafka Consumer application

You can start this application in two ways:
- **Option 1**: open command line on folder **springboot-kafka-consumer** and run following Maven command: **mvn spring-boot:run**
- **Option 2**: in application **springboot-kafka-consumer** open class **Application.java** and run method **main()**

##### Ad 4\ Send message
To send message by Producer please:
- Open any browser
- Type following URL there: **http://localhost:8080/greeting/name/{name}** (for instance: http://localhost:8080/greeting/name/Chris)
- Message **Done** should be displayed in browser

##### Ad 5\ Read message
To read the message please check logs of Consumer application. Following message should be displayed there: **Hello World {name}**. For instance: Hello World Chris.

##### Ad 6\ Clean up
To clean up applications:
- Stop Spring Boot Kafka Producer application
- Stop Spring Boot Kafka Consumer application
- Stop Kafka Server: in command line press **ctrl + C** and then type **docker-compose down**