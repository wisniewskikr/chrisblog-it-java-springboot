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
The goal of this project is to present how to implement **security** in **REST API** application using **Keycloak** tool with usage **Java** programming language and **Spring Boot 3** framework. This application is used as **resource server** (verifies JWT tokens) and for authentication uses **authorization code** (two steps: 1. User logs in and gets authorization code; 2. User generates token basing on authorization code).

##### Elements
This project consists of following elements:
* **Rest API**: Rest API application which returns
   * Not secured "Hello World!" message
   * Secured "Hello World, User!" message
   * Secured "Hello World, Admin!" message  
* **Keycloak**: IAM tool for user management and entrypoint for JWT

##### Terminology
Terminology explanation:
* **Git**: tool for distributed version control
* **Maven**: tool for build automation
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **REST API**: A REST API (Representational State Transfer API) is a web service that allows systems to communicate over HTTP using standard methods like GET, POST, PUT, and DELETE. It follows REST principles, ensuring scalability, statelessness, and resource-based interactions, typically using JSON or XML for data exchange.
* **Keycloak**: Keycloak is an open-source identity and access management solution that provides authentication, authorization, and user management for applications and services. It supports Single Sign-On (SSO), social logins, multi-factor authentication, and integration with LDAP and Active Directory.
* **Resource Server**: is a Spring Boot starter that provides auto-configuration and dependencies to build an OAuth2 resource server. It enables authentication and authorization by validating access tokens issued by an OAuth2 authorization server.
* **Authorization Code Grant**: it is an OAuth 2.0 flow used for securely obtaining an access token. It is commonly used by web and mobile apps that need to authenticate users via a third-party authorization server. 

Authorization Code Grant steps:
1. User Authorization – The user is redirected to the authorization server and logs in.
1. Authorization Code Issued – After successful login, the authorization server redirects back with a short-lived authorization code.
1. Code Exchange for Token – The client app sends the authorization code to the authorization server (along with client credentials) to obtain an access token (and optionally a refresh token).
1. Access Token Usage – The client uses the access token to access protected resources on behalf of the user.


USAGES
------

This project can be tested in following configurations:
* **Usage Docker Compose**: all services are started as Docker containers definied in docker compose file.
* **Usage Kubernetes (Kind)**: all services are started as Kubernetes pods.


USAGE DOCKER COMPOSE
--------------------

> **Usage Docker Compse** means all services are started as Docker containers definied in docker compose file.

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**.

> **Prerequisites**:  
* **Operating System** (tested on Windows 11)
* **Git** (tested on version 2.33.0.windows.2)
* **Docker** (tested on version 4.33.1)

##### Required steps:
1. Update **hosts** file (Run as Administrator; Windows: "Windows\System32\drivers\etc\hosts"; MAC/Linux: "etc/hosts") with new line **127.0.0.1 keycloak**
1. Start **Docker** tool
1. In a command line tool **start Docker containers** with `docker-compose up -d --build`
1. In any REST Client (e.g. Postman) visit **Keycloack** with `http://localhost:9090/api/v1/demo/user`
   * Authorization -> OAuth 2.0
   * Grant Type: **Authorization Code**
   * Callback URL: **http://localhost:9090/code**
   * Auth URL: **http://keycloak:8080/realms/helloworld-realm/protocol/openid-connect/auth**
   * Access Token URL: **http://keycloak:8080/realms/helloworld-realm/protocol/openid-connect/token**
   * Client Id: **helloworld-client**
   * Client Secret: **helloworld-secret**
   * Scope: **openid**
   * Click **Get New Access Token**
   * Expected JWT token
1. In any REST Client (e.g. Postman) visit **REST API** application with (method **GET**) `http://localhost:9090/api/v1/demo/user`
   * Bearer Token: JWT token
   * Expected "Hello World, User!" message
1. Clean up environment 
     * In a command line tool **remove Docker containers** with `docker-compose down --rmi all`
     * Stop **Docker** tool
     * Remove new line from **hosts**

##### Optional steps:
1. In a command line tool validate Docker Compose with `docker-compose config`
1. In a command line tool check list of Docker images with `docker images`
1. In a command line tool check list of all Docker containers with `docker ps -a`
1. In a command line tool check list of active Docker containers with `docker ps`
1. In a command line tool check list of Docker nerworks with `docker network ls`
1. In a command line tool check BE container logs with `docker logs be-container`
1. In a command line tool check FE container logs with `docker logs fe-container`


USAGE KUBERNETES (KIND)
---------------------------

> **Usage Kubernetes** means that all services are started as Kubernetes pods. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**.

> **Prerequisites**:  
* **Operating System** (tested on Windows 11)
* **Git** (tested on version 2.33.0.windows.2)
* **Kind** (tested on version 0.26.0)

##### Required steps:
1. Update **hosts** file (Run as Administrator; Windows: "Windows\System32\drivers\etc\hosts"; MAC/Linux: "etc/hosts") with new line **127.0.0.1 keycloak.default.svc.cluster.local**
1. Start **Docker** tool
1. In the first command line tool create and start cluster **Kind** with `kind create cluster --name helloworld`
1. In the second command line tool **start Kubernetes Pods** with `kubectl apply -f kubernetes.yaml`
1. In the second command line tool **check status of Kubernetes Pods** with `kubectl get pods`
   * Expected mysql, be and fe as **READY 1/1** (it can take few minutes)
1. In the second command line tool **forward port of Keycloak service** with `kubectl port-forward service/keycloak 8080:8080`
1. In the third command line tool **forward port of App service** with `kubectl port-forward service/app 9090:9090`
1. In any REST Client (e.g. Postman) visit **Keycloack** with `http://localhost:9090/api/v1/demo/user`
   * Authorization -> OAuth 2.0
   * Grant Type: **Authorization Code**
   * Callback URL: **http://localhost:9090/code**
   * Auth URL: **http://keycloak.default.svc.cluster.local:8080/realms/helloworld-realm/protocol/openid-connect/auth**
   * Access Token URL: **http://keycloak.default.svc.cluster.local:8080/realms/helloworld-realm/protocol/openid-connect/token**
   * Client Id: **helloworld-client**
   * Client Secret: **helloworld-secret**
   * Scope: **openid**
   * Click **Get New Access Token**
   * Expected JWT token
1. In any REST Client (e.g. Postman) visit **REST API** application with (method **GET**) `http://localhost:9090/api/v1/demo/user`
   * Bearer Token: JWT token
   * Expected "Hello World, User!" message
1. Clean up environment 
     * In the third command line tool **stop forwarding port of App service** with `ctrl + C`
     * In the second command line tool **stop forwarding port of Keycloak service** with `ctrl + C`
     * In the second command line tool **remove Kubernetes Pods** with `kubectl delete -f kubernetes.yaml`
     * In the first command line tool delete cluster **Kind** with `kind delete cluster --name helloworld`
     * Stop **Docker** tool
     * Remove new line from **hosts**

##### Optional steps:
1. In a command line tool build Docker App image with `docker build -t wisniewskikr/springboot3-api-rest-security-resourceserver-authorizationcode-keycloak-users:0.0.1 .`
1. In a command line tool push Docker App image to Docker Repository with `docker push wisniewskikr/springboot3-api-rest-security-resourceserver-authorizationcode-keycloak-users:0.0.1` 
1. In the first command line tool with administrator privileges check clusers with `kind get clusters`
1. In a command line tool check Kubernetes Deployments with `kubectl get deployments`
1. In a command line tool check Kubernetes Deployments details with **kubectl describe deployment {deployment-name}**
1. In a command line tool check Kubernetes Services with `kubectl get services`
1. In a command line tool check Kubernetes Services details with **kubectl describe service {service-name}**
1. In a command line tool check Kubernetes Pods with `kubectl get pods`
1. In a command line tool check Kubernetes Pods details with **kubectl describe pod {pod-name}**
1. In a command line tool check Kubernetes Pods logs with **kubectl logs {pod-name}**


KEYCLOAK CONFIGURATION
----------------------

![My Image](readme-images/config-01.png)

![My Image](readme-images/config-02.png)

![My Image](readme-images/config-03.png)

![My Image](readme-images/config-04.png)

![My Image](readme-images/config-05.png)

![My Image](readme-images/config-06.png)

![My Image](readme-images/config-07.png)

![My Image](readme-images/config-08.png)

![My Image](readme-images/config-09.png)

![My Image](readme-images/config-10.png)

![My Image](readme-images/config-11.png)

![My Image](readme-images/config-12.png)

![My Image](readme-images/config-13.png)

![My Image](readme-images/config-14.png)

![My Image](readme-images/config-15.png)