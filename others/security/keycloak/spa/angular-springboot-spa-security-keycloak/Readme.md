EXAMPLE
-------

![My Image](readme-images/image-01.png)

![My Image](readme-images/image-02.png)

![My Image](readme-images/image-03.png)

![My Image](readme-images/image-04.png)

![My Image](readme-images/image-05.png)

![My Image](readme-images/image-06.png)

![My Image](readme-images/image-07.png)

![My Image](readme-images/image-08.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to user **Keycloak** for securing **front-end** and **back-end** applications. Front-end application - basing on **Typescript and Angular** framework - and back-end application - basing on **Java and Spring Boot** framework.

##### Elements
This project consists of following elements:
* **BE**: Java Spring Boot 3 Rest API application which returns:
   * Message "Hello World!" 
* **FE**: Angular application which displays:
   * Message "Hello World!" from BE application
* **Keycloak**: tool for securing applications

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **API REST**: an architectural style for an application program interface (API) that uses HTTP requests to access and use data
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Maven**: tool for build automation
* **Git**: tool for distributed version control
* **Typescript**: it's superset of Javascript. It means that it contains everything like Javascript plus it's strongly typed, it provides OOPS elements etc. 
* **Angular**: it's component-based framework for building structured single page applications on client side. 
* **Keycloak**: it is an open-source identity and access management solution that provides authentication, authorization, and single sign-on (SSO) capabilities for applications and services. It supports various authentication protocols like OAuth 2.0, OpenID Connect, and SAML.


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
1. Start **Docker** tool
1. In a command line tool **start Docker containers** with `docker-compose up -d --build`
   * Wait **few minutes** when Keycloak is loaded
1. In any Internet Browser (e.g. Chrome) visit **Fe** application with `http://localhost:4200`
   * **Public Page**: expected not secured API call to Be and result **Hello World, Public!**
   * **Secured Page**: expected secured API call to Be and result **Hello World, Secured!**
1. Clean up environment 
     * In a command line tool **remove Docker containers** with `docker-compose down --rmi all`
     * Stop **Docker** tool

##### Optional steps:
1. In a command line tool validate Docker Compose with `docker-compose config`
1. In a command line tool check list of Docker images with `docker images`
1. In a command line tool check list of all Docker containers with `docker ps -a`
1. In a command line tool check list of active Docker containers with `docker ps`
1. In a command line tool check list of Docker nerworks with `docker network ls`
1. In a command line tool check BE container logs with `docker logs be`
1. In a command line tool check FE container logs with `docker logs fe`


USAGE KUBERNETES (KIND)
-----------------------

> **Usage Kubernetes** means that all services are started as Kubernetes pods. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**.

> **Prerequisites**:  
* **Operating System** (tested on Windows 11)
* **Git** (tested on version 2.33.0.windows.2)
* **Kind** (tested on version 0.26.0)

##### Required steps:
1. Start **Docker** tool
1. In the first command line tool create and start cluster **Kind** with `kind create cluster --name helloworld`
1. In the second command line tool **start Kubernetes Pods** with `kubectl apply -f kubernetes.yaml`
1. In the first command line tool **check status of Kubernetes Pods** with `kubectl get pods`
   * Expected mysql, be and fe as **READY 1/1** (it can take few minutes)
1. In the second command line tool **forward port of Keycloak service** with `kubectl port-forward service/keycloak 8080:8080`
1. In the third command line tool **forward port of Fe service** with `kubectl port-forward service/fe 4200:4200`
1. In the fourth command line tool **forward port of Be service** with `kubectl port-forward service/be 9090:9090`
1. In any Internet Browser (e.g. Chrome) visit **Fe** application with `http://localhost:4200`
   * **Public Page**: expected not secured API call to Be and result **Hello World, Public!**
   * **Secured Page**: expected secured API call to Be and result **Hello World, Secured!**
1. Clean up environment 
     * In the fourth command line tool **stop forwarding port of Be service** with `ctrl + C`
     * In the third command line tool **stop forwarding port of Fe service** with `ctrl + C`
     * In the second command line tool **stop forwarding port of Keycloak service** with `ctrl + C`
     * In the first command line tool **remove Kubernetes Pods** with `kubectl delete -f kubernetes.yaml`
     * In the first command line tool delete cluster **Kind** with `kind delete cluster --name helloworld`
     * Stop **Docker** tool

##### Optional steps:
1. In a command line tool build Docker BE image with `docker build -f angular-springboot-spa-security-keycloak-be/Dockerfile -t wisniewskikr/angular-springboot-spa-security-keycloak-be:0.0.1 ./angular-springboot-spa-security-keycloak-be`
1. In a command line tool push Docker BE image to Docker Repository with `docker push wisniewskikr/angular-springboot-spa-security-keycloak-be:0.0.1` 
1. In a command line tool build Docker FE image with `docker build -f angular-springboot-spa-security-keycloak-fe/Dockerfile -t wisniewskikr/angular-springboot-spa-security-keycloak-fe:0.0.1 ./angular-springboot-spa-security-keycloak-fe`
1. In a command line tool push Docker FE image to Docker Repository with `docker push wisniewskikr/angular-springboot-spa-security-keycloak-fe:0.0.1` 
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

FE:
* Update file "package.json" with "angular-oauth2-oidc": "^17.0.0"
* Call command "npm install"
* Add file "auth.config.ts"
* Update file "app.config.ts" with "provideOAuthClient" and "OAuthModule"
* Update file "app.component.ts" with constuctor parameter OAuthService and methods configure(), login() and logout()
* Update file "app.component.html" with links "Login" and "Logout" 

BE:
* Update file "pom.xml" with dependencies "spring-boot-starter-security" and "spring-boot-starter-oauth2-resource-server"
* Update file "application.yaml" with spring security properties
* Add class SecurityConfig