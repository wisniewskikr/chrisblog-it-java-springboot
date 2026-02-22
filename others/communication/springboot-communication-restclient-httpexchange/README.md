EXAMPLE
-------

![My Image](readme-images/image-01.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **communication** between two **REST API** applications 
with usage **Java** programming language and **Spring Boot 3** framework. Class **RestClient** with an interface
**HttoExchange** is used for this communication.

##### Elements
This project consists of following elements:
* **First** service: rest API application
* **Second** service: rest API application

##### Terminology
Terminology explanation:
* **Git**: Git is a distributed version control system (VCS) that tracks changes in code, allowing multiple developers to collaborate efficiently. It helps manage different versions of a project, enabling branching, merging, and rollback to previous states.
* **Maven**: Maven is a build automation and project management tool for Java-based projects, used primarily for dependency management and project configuration.
* **Java**: Java is a high-level, object-oriented programming language known for its platform independence, achieved through the Java Virtual Machine (JVM). It is widely used for web, mobile, and enterprise applications. Java follows the "write once, run anywhere" (WORA) principle, making it a popular choice for cross-platform development.
* **Spring Boot**: Spring Boot is a Java-based framework that simplifies the development of stand-alone, production-ready Spring applications by providing auto-configuration, embedded servers, and a convention-over-configuration approach.
* **REST API**: A REST API (Representational State Transfer API) is a web service that allows systems to communicate over HTTP using standard methods like GET, POST, PUT, and DELETE. It follows REST principles, ensuring scalability, statelessness, and resource-based interactions, typically using JSON or XML for data exchange.
* **RestClient**: A RestClient is a tool, library, or object used to send HTTP requests and receive responses from RESTful web services. It simplifies communication with APIs by handling methods like GET, POST, PUT, and DELETE, often providing features like authentication, headers, and data serialization.
* **HttpExchange**: The HttpExchange interface (from the Java package com.sun.net.httpserver) represents a single HTTP request–response exchange between a client and a server.


USAGES
------

This project can be tested in following configurations:
* **Usage Manual**: infrastructure services are started as Docker containers. Application services are started manually in command line
* **Usage Docker Compose**: all services are started as Docker containers defined in docker compose file.
* **Usage Kubernetes (Kind)**: all services are started as Kubernetes pods.


USAGE MANUAL
------------

> **Usage Manual** means that infrastructure services are started as Docker containers. Application services are started manually in command line.

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**.

> **Prerequisites**:
* **Operating System** (tested on Windows 11)
* **Git** (tested on version 2.33.0.windows.2)

##### Required steps:
1. In a first command line tool **start Second application** with `mvn -f ./springboot-communication-restclient-httpexchange-second spring-boot:run`
1. In a second command line tool **start First application** with `mvn -f ./springboot-communication-restclient-httpexchange-first spring-boot:run`
1. In any REST Client (e.g. Postman) visit **first** application with `http://localhost:8080/api/v1/message`
    * Expected JSON with "Hello World!" message
1. Clean up environment:
    * In the second command line tool **stop Second application** with `ctrl + C`
    * In the first command line tool **stop First application** with `ctrl + C`


USAGE DOCKER COMPOSE
--------------------

> **Usage Docker Compose** means all services are started as Docker containers defined in docker compose file.

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**.

> **Prerequisites**:
* **Operating System** (tested on Windows 11)
* **Git** (tested on version 2.33.0.windows.2)
* **Docker** (tested on version 4.33.1)

##### Required steps:
1. Start **Docker** tool
1. In a command line tool **start Docker containers** with `docker-compose up -d --build`
1. In any REST Client (e.g. Postman) visit **first** application with `http://localhost:8080/api/v1/message`
   * Expected JSON with "Hello World!" message
1. Clean up environment 
     * In a command line tool **remove Docker containers** with `docker-compose down --rmi all`
     * Stop **Docker** tool

##### Optional steps:
1. In a command line tool validate Docker Compose with `docker-compose config`
1. In a command line tool check list of Docker images with `docker images`
1. In a command line tool check list of all Docker containers with `docker ps -a`
1. In a command line tool check list of active Docker containers with `docker ps`
1. In a command line tool check list of Docker networks with `docker network ls`
1. In a command line tool check container logs with `docker logs {container-name}`


USAGE KUBERNETES (KIND)
---------------------------

> **Usage Kubernetes** means that all services are started as Kubernetes pods.

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**.

> **Prerequisites**:
* **Operating System** (tested on Windows 11)
* **Git** (tested on version 2.33.0.windows.2)
* **Kind** (tested on version 0.26.0)

##### Required steps:
1. Start **Docker** tool
1. In the first command line tool create and start cluster **Kind** with `kind create cluster --name helloworld`
1. In the first command line tool **start Kubernetes Pods** with `kubectl apply -f ./k8s --recursive`
1. In the first command line tool **check status of Kubernetes Pods** with `kubectl get pods`
   * Expected mysql, second and first as **READY 1/1** (it can take few minutes)
1. In the first command line tool **forward port of First service** with `kubectl port-forward service/first 8080:8080`
1. In the second command line tool **forward port of Second service** with `kubectl port-forward service/second 9090:9090`
1. In any REST Client (e.g. Postman) visit **first** application with `http://localhost:8080/api/v1/message`
   * Expected JSON with "Hello World!" message
1. Clean up environment
   * In the second command line tool **stop forwarding port of Second service** with `ctrl + C`
   * In the first command line tool **stop forwarding port of First service** with `ctrl + C`
   * In the first command line tool **remove Kubernetes Pods** with `kubectl delete -f ./k8s --recursive`
   * In the first command line tool delete cluster **Kind** with `kind delete cluster --name helloworld`
   * Stop **Docker** tool

##### Optional steps:
1. In a command line tool build Docker SECOND image with `docker build -f springboot-communication-restclient-httpexchange-second/Dockerfile -t wisniewskikr/springboot-communication-restclient-httpexchange-second:0.0.1 ./springboot-communication-restclient-httpexchange-second`
1. In a command line tool push Docker SECOND image to Docker Repository with `docker push wisniewskikr/springboot-communication-restclient-httpexchange-second:0.0.1`
1. In a command line tool build Docker FIRST image with `docker build -f springboot-communication-restclient-httpexchange-first/Dockerfile -t wisniewskikr/springboot-communication-restclient-httpexchange-first:0.0.1 ./springboot-communication-restclient-httpexchange-first`
1. In a command line tool push Docker FIRST image to Docker Repository with `docker push wisniewskikr/springboot-communication-restclient-httpexchange-first:0.0.1`
1. In the first command line tool with administrator privileges check clusters with `kind get clusters`
1. In a command line tool check Kubernetes Deployments with `kubectl get deployments`
1. In a command line tool check Kubernetes Deployments details with **kubectl describe deployment {deployment-name}**
1. In a command line tool check Kubernetes Services with `kubectl get services`
1. In a command line tool check Kubernetes Services details with **kubectl describe service {service-name}**
1. In a command line tool check Kubernetes Pods with `kubectl get pods`
1. In a command line tool check Kubernetes Pods details with **kubectl describe pod {pod-name}**
1. In a command line tool check Kubernetes Pods logs with **kubectl logs {pod-name}**