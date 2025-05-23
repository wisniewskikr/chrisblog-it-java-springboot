EXAMPLE
-------

![My Image](readme-images/image-01.png)

![My Image](readme-images/image-02.png)

![My Image](readme-images/image-03.png)

![My Image](readme-images/image-04a.png)

![My Image](readme-images/image-04b.png)

![My Image](readme-images/image-05.png)

![My Image](readme-images/image-06.png)

![My Image](readme-images/image-07.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **security** in **MVC (Thymeleaf)** application using **Keycloak** tool with usage **Java** programming language and **Spring Boot 3** framework. Security is based on authorization grant type **Authorization Code with PKCE**. Authorization Code with PKCE means that developer don't need store secret ID in application. This application handles **users** with roles. User has access to only specific secured resouce after log in.

##### Elements
This project consists of following elements:
* **MVC**: this application consists of
   * Public Page: available without log in
   * User Page: available only after log in for USER and ADMIN roles
   * Admin Page: available only after log in for ADMIN role
* **Keycloak**: IAM tool for user management

##### Terminology
Terminology explanation:
* **Git**: tool for distributed version control
* **Maven**: tool for build automation
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **MVC**: MVC is a design pattern that separates an application into three components: 1. Model: Manages data and business logic. 2. View: Handles UI and presentation (Thymeleaf templates in Spring Boot). 3. Controller: Processes user requests, interacts with the model, and updates the view.
* **Keycloak**: Keycloak is an open-source identity and access management solution that provides authentication, authorization, and user management for applications and services. It supports Single Sign-On (SSO), social logins, multi-factor authentication, and integration with LDAP and Active Directory.
* **Authorization Code with PKCE Grant**: Authorization Code with Proof Key for Code Exchange (PKCE) is an OAuth 2.0 extension that enhances security for public clients (e.g., mobile and SPAs) by preventing authorization code interception attacks. Instead of using a client secret, PKCE introduces a dynamically generated code verifier and its code challenge, ensuring that only the original client can exchange the authorization code for a token.


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
1. In a browser visit **MVC** with `http://localhost:9090`
    * Expected Landing page
    * Click **Public Page**: expected not secured public page
    * Click **User Page**: expected "Login" page with "Registration" link. Then expected secured user page for manually registered user (default role USER)
    * Click **Admin Page**: expected "Login" page with "Registration" link. Then expected no permission message for manually registered user (default role USER)
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
1. In a browser visit **MVC** with `http://localhost:9090`
    * Expected Landing page
    * Click **Public Page**: expected not secured public page
    * Click **User Page**: expected "Login" page with "Registration" link. Then expected secured user page for manually registered user (default role USER)
    * Click **Admin Page**: expected "Login" page with "Registration" link. Then expected no permission message for manually registered user (default role USER)
1. Clean up environment 
     * In the third command line tool **stop forwarding port of App service** with `ctrl + C`
     * In the second command line tool **stop forwarding port of Keycloak service** with `ctrl + C`
     * In the second command line tool **remove Kubernetes Pods** with `kubectl delete -f kubernetes.yaml`
     * In the first command line tool delete cluster **Kind** with `kind delete cluster --name helloworld`
     * Stop **Docker** tool
     * Remove new line from **hosts**

##### Optional steps:
1. In a command line tool build Docker App image with `docker build -t wisniewskikr/springboot3-mvc-thymeleaf-security-client-authorizationcodepkce-keycloak-roles:0.0.1 .`
1. In a command line tool push Docker BE image to Docker Repository with `docker push wisniewskikr/springboot3-mvc-thymeleaf-security-client-authorizationcodepkce-keycloak-roles:0.0.1` 
1. In the first command line tool with administrator privileges check clusers with `kind get clusters`
1. In a command line tool check Kubernetes Deployments with `kubectl get deployments`
1. In a command line tool check Kubernetes Deployments details with **kubectl describe deployment {deployment-name}**
1. In a command line tool check Kubernetes Services with `kubectl get services`
1. In a command line tool check Kubernetes Services details with **kubectl describe service {service-name}**
1. In a command line tool check Kubernetes Pods with `kubectl get pods`
1. In a command line tool check Kubernetes Pods details with **kubectl describe pod {pod-name}**
1. In a command line tool check Kubernetes Pods logs with **kubectl logs {pod-name}**


IMPLEMENTATION
--------------

In the file **application.yml** replace **client-secret:** with **client-authentication-method: none**.


KEYCLOAK CONFIGURATION
----------------------

Credentials: **admin/admin**

![My Image](readme-images/config-01.png)

![My Image](readme-images/config-02.png)

![My Image](readme-images/config-03.png)

![My Image](readme-images/config-04.png)

![My Image](readme-images/config-05.png)

![My Image](readme-images/config-06.png)

![My Image](readme-images/config-07.png)

![My Image](readme-images/config-08a.png)

![My Image](readme-images/config-08b.png)

![My Image](readme-images/config-09.png)

![My Image](readme-images/config-10.png)

![My Image](readme-images/config-11.png)

![My Image](readme-images/config-12.png)

![My Image](readme-images/config-12a.png)

![My Image](readme-images/config-12b.png)

![My Image](readme-images/config-12c.png)

![My Image](readme-images/config-13.png)

![My Image](readme-images/config-14.png)

![My Image](readme-images/config-15.png)

![My Image](readme-images/config-16.png)

![My Image](readme-images/config-17.png)

![My Image](readme-images/config-18.png)

![My Image](readme-images/config-19.png)

![My Image](readme-images/config-20.png)

![My Image](readme-images/config-21.png)

![My Image](readme-images/config-22.png)

![My Image](readme-images/config-23.png)

![My Image](readme-images/config-24.png)

![My Image](readme-images/config-25.png)

![My Image](readme-images/config-26.png)

![My Image](readme-images/config-27.png)

![My Image](readme-images/config-28.png)

![My Image](readme-images/config-29.png)

![My Image](readme-images/config-30.png)
