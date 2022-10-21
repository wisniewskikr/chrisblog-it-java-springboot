DESCRIPTION
-----------

##### Goal
The goal of this project is to show how to send JMS messages from one Spring Boot application to other using Rabbit MQ JMS broker. 

Message type Topic means that one message is sent from one Producer to many Consumers at the same time.

##### Details
Project elements:
* **Rabbit MQ server**: JMS broker - tool which enable sending and receiving JMS messages
* **Spring Boot Producer application**: application which sends messages to Rabbit MQ. Producer's one message is accessible manually by APi and accessible automatically by Listener in Consumer application
* **Spring Boot Consumer application**: application which receives messages from Rabbit MQ. Two types of message are read here - accessible manually by API or accessible automatically by Listener

##### Technologies
Used technologies:
* Java
* Maven
* Git
* Spring Boot
* Docker Compose
* Rabbit MQ


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed Java
* Installed Maven
* Installed Git
* Installed Docker (with Docker Compose)

##### Preconditions - Actions
* Start Docker: only if it's not aleady running;
* Download Source Code: only if it hasn't been downloaded yet. Git command: **git clone https://github.com/wisniewskikr/java-messaging.git**


USAGE
-----

Usage steps:
1. Start Rabbit MQ Server (docker compose)
2. Start Spring Boot Rabbit MQ Producer application
3. Start Spring Boot Rabbit MQ Consumer application
4. Send message
5. Read message
6. Clean up

##### Ad 1\ Start Rabbit MQ Server (docker compose)

To start Rabbit MQ Server the tool **docker compose** is required.
To start this tool please open command line on folder **springboot-rabbitmq-server** and run following command there: 
* **docker-compose up**

To check if it works correctly:
* Open any browser and paste following URL: **http://localhost:15672**
* Credentials: **guest:guest**
* Check if following queues are created: **greeting-api** and **greeting-listener**

##### Ad 2\ Start Spring Boot Rabbit MQ Producer application

To start this application please open command line on folder **springboot-rabbitmq-producer** and run following Maven command: 
* **mvn spring-boot:run**

##### Ad 3\ Start Spring Boot Rabbit MQ Consumer application

To start this application please open command line on folder **springboot-rabbitmq-consumer** and run following Maven command: 
* **mvn spring-boot:run**

##### Ad 4\ Send message
To send message accessible manually by API in Consumer application please put following URL in any browser: 
* **http://localhost:8080/greeting/name/{name}** (for instance: http://localhost:8080/greeting/name/Chris). 

After successful action message **Done** should be displayed

##### Ad 5\ Read message
To read messages manually open browser and type there following URL: 
* **http://localhost:9090/greeting/type/api/message**

Message **Hello World {name}** should be displayed. For instance **Hello World Chris**

To see messages read automatically by Consumer's listener please open Consumer console. Message **Hello World {name}** should be displayed. For instance **Hello World Chris**

##### Ad 6\ Clean up
To clean up applications:
- Stop Spring Boot Rabbit MQ Producer application
- Stop Spring Boot Rabbit MQ Consumer application
- Stop Rabbit MQ Server: in command line press **ctrl + C** and then type **docker-compose down**
