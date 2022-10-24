### REPOSITORY DESCRIPTION

This repository contains Java projects with examples of configuration and usage of messaging architecture. 

Messaging architecture means that there is no direct connection between client and server. Between them there is element called "broker". Result of such approach is that such architecture is much more flexible - you can use many clients and server (producers and consumers) fot the same event (message).

Recommended projects:
- **springboot-rabbitmq-queue-docker-compose**: basic example of usage JMS messages with broker RabbitMQ and with Java Spring Boot applications. JMS message is type Queue so it means that only one Consumer can read it. All elements in this example are configured as Docker and Docker Compose elements;
- **springboot-rabbitmq-topic-docker-compose**: basic example of usage JMS messages with broker RabbitMQ and with Java Spring Boot applications. JMS message is type Topic so it means that many Consumers can read it. All elements in this example are configured as Docker and Docker Compose elements;; 
- **springboot-kafka-wurstmeister-docker-compose**: basic example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose;
- **springboot-kafka-wurstmeister-docker-compose-full**: more sophisticated example - many elements, more flexible configuration - of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose.

### PROJECTS LIST

List of projects in this repository together with short description:

- **springboot-rabbitmq-queue**: basic example of usage JMS messages with broker RabbitMQ and with Java Spring Boot applications. JMS message is type Queue so it means that only one Consumer can read it;
- **springboot-rabbitmq-queue-docker-compose**: basic example of usage JMS messages with broker RabbitMQ and with Java Spring Boot applications. JMS message is type Queue so it means that only one Consumer can read it. All elements in this example are configured as Docker and Docker Compose elements;
- **springboot-rabbitmq-topic**: basic example of usage JMS messages with broker RabbitMQ and with Java Spring Boot applications. JMS message is type Topic so it means that many Consumers can read it;
- **springboot-rabbitmq-topic-docker-compose**: basic example of usage JMS messages with broker RabbitMQ and with Java Spring Boot applications. JMS message is type Topic so it means that many Consumers can read it. All elements in this example are configured as Docker and Docker Compose elements;; 
- **springboot-kafka-confluentinc**: basic example of usage Kafka event storing technology (type Confluentinc) with Java Spring Boot application;
- **springboot-kafka-confluentinc-docker-compose**: basic example of usage Kafka event storing technology (type Confluentinc) with Java Spring Boot application. This example uses Docker Compose technology to configure and run all elements in project;
- **springboot-kafka-wurstmeister**: basic example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application;
- **springboot-kafka-wurstmeister-consumer-auto-offset-reset-WIP**: this project is still **Work In Progress** - it means that it doesn't work correctly. Example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "auto offset reset" in Consumer application is and how to configure it;
- **springboot-kafka-wurstmeister-consumer-enable-auto-commit-WIP**: this project is still **Work In Progress** - it means that it doesn't work correctly. Example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "enable auto commit" in Consumer application is and how to configure it;
- **springboot-kafka-wurstmeister-consumer-groups-id**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "group id" in Consumer application is and how to configure it;
- **springboot-kafka-wurstmeister-consumer-partition-offsets**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "partition offset" in Consumer application is and how to configure it;
- **springboot-kafka-wurstmeister-consumer-topic-partition**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "topic partition" in Consumer application is and how to configure it;
- **springboot-kafka-wurstmeister-docker-compose**: basic example of usage Kafka event storing technology with Java Spring Boot application and Docker Compose;
- **springboot-kafka-wurstmeister-docker-compose-full**: more sophisticated example - many elements, more flexible configuration - of usage Kafka event storing technology with Java Spring Boot application and Docker Compose.
- **springboot-kafka-wurstmeister-many-clusters**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "Kafka Cluster" is and how to configure it;
- **springboot-kafka-wurstmeister-many-consumers**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "Kafka Consumer" is and how to configure many of it in one project;
- **springboot-kafka-wurstmeister-many-producers**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "Kafka Producer" is and how to configure many of it in one project;
- **springboot-kafka-wurstmeister-many-zookeepers**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "Zookeeper" is and how to configure many of it in one project;
- **springboot-kafka-wurstmeister-producer-partitions**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "partitions" in Producer application is and how to configure it;
- **springboot-kafka-wurstmeister-producer-replicas**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "replicas" in Producer application is and how to configure it;
- **springboot-kafka-wurstmeister-producer-retention**: example of usage Kafka event storing technology (type Wurstmeister) with Java Spring Boot application and Docker Compose. It tries to explain what "retentions" in Producer application is and how to configure it.
