EXAMPLE
-------

![My Image](readme-images/image-01.png)

![My Image](readme-images/image-02.png)

![My Image](readme-images/image-03.png)

![My Image](readme-images/image-04.png)

![My Image](readme-images/image-05.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use **Kafka** type **KRaft** for implementation of asynchronous communication between two applications created with usage **Java** programming language and **Spring Boot 3** framework. Additionally **Krafka UI** is used to present messages sent between these two applications.

##### 
This project consists of following applications:
* **Producer**: sends events to Kafka broker
* **Consumer**: receives events from Kafka broker
* **Kafka**: acts as an intermediary between the producer and the consumer
* **Kafka UI**: displays events handled by Kafka broker

##### Inputs
This project requires following inputs:
* **Producer**: handles http request from any browser
* **Kafka UI**: handles http request from any browser

##### Outputs
This project provides following outputs:
* **Producer**: sends http response to any browser
  * Message **Done** is sent
* **Kafka UI**: sends http responses to any browser
  * Dashboard with Kafka events is sent

##### Terminology
Terminology explanation:
* **Git**: Git is a distributed version control system used to track changes in code, collaborate with others, and manage source code history efficiently.
* **Java**: Java is a high-level, object-oriented programming language known for its platform independence, achieved through the Java Virtual Machine (JVM). It is widely used for developing web, mobile, desktop, and enterprise applications, emphasizing simplicity, security, and portability. "Write once, run anywhere" is its core principle.
* **Maven**: Maven is a build automation and dependency management tool for Java projects, streamlining project builds, managing libraries, and ensuring consistent project configurations.
* **Spring Boot**: Spring Boot is a framework for building Java-based applications that simplifies development by providing auto-configuration, embedded servers, and production-ready tools, enabling developers to create standalone, production-ready applications with minimal configuration.
* **Kafka KRaft**: Kafka KRaft (Kafka Raft) is a mode of running Apache Kafka without the need for Apache ZooKeeper. It uses the Raft consensus algorithm for managing metadata and leader election, simplifying the architecture by removing ZooKeeper's dependency while maintaining Kafka's distributed, fault-tolerant capabilities. This mode enhances scalability and operational simplicity.
* **Kafka UI**: Kafka UI is a web-based interface for managing and monitoring Apache Kafka clusters. It allows users to visualize topics, partitions, consumer groups, and messages, making it easier to interact with Kafka without using the command line.
* **Asynchronous Communication**: Asynchronous communication is the exchange of information without requiring participants to be present or respond in real time, allowing for flexibility in timing (e.g., emails or messaging apps).
* **Docker**: Docker is a platform that allows you to build, run, and manage applications in lightweight, portable containers. These containers package the application and its dependencies, ensuring consistency across development, testing, and production environments.
* **Docker Compose**: Docker Compose is a tool for defining and running multi-container Docker applications using a simple YAML configuration file (docker-compose.yml). It allows you to specify services, networks, and volumes, enabling easy orchestration and management of containerized applications.
* **Kubernetes**: Kubernetes is an open-source platform for automating the deployment, scaling, and management of containerized applications. It organizes containers into logical units called pods and helps ensure high availability, scalability, and efficient resource utilization.
* **Kind**: Kubernetes Kind (Kubernetes IN Docker) is a tool for running Kubernetes clusters locally using Docker containers. It allows developers to easily create and manage multi-node Kubernetes clusters for testing and development purposes in a lightweight environment.


USAGES
------

This project can be tested in following configurations:
* **Usage Docker Compose (Recommended)**: all services are started as Docker containers definied in a Docker Compose file.
* **Usage Kubernetes (Kind) (Recommended)**: all services are started as Kubernetes pods.
* **Usage Manual + Docker**: custom services are started manually from command line. Other services (like Sql Databases, NoSql Databases etc.) are started as Docker containers.
* **Usage Docker**: all services are started as Docker containers.


USAGE DOCKER COMPOSE (RECOMMENDED)
----------------------------------

> **Usage Docker Compse** means all services are started as Docker containers definied in Docker Compose file.

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**.

> **Prerequisites**:  
* **Operating System** (tested on Windows 11)
* **Git** (tested on version 2.33.0.windows.2)
* **Docker** (tested on version 4.33.1) 

Usage steps:
1. Start **Docker** tool
1. In a command line tool **start Docker containers** with `docker-compose -f .\docker-compose\docker-compose.yml up -d --build`
1. In a browser visit `http://localhost:8080/helloworld/name/{name}` (f.e `http://localhost:8080/helloworld/name/Stranger`)
   * Expected text **Done** in the browser
1. In a browser visit `http://localhost:8086`
   * Expected **dashboard** of Kafka UI (check section **EXAMPLE**)
   * Fill **Cluster name** as **localhost**
   * Fill **Host** as **kafka**
   * Fill **Port** as **9092**
1. Clean up environment
    * Remove containers `docker-compose -f .\docker-compose\docker-compose.yml down --rmi all`
    * Stop **Docker** tool