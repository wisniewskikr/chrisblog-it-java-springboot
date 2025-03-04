EXAMPLE
-------

![My Image](readme-images/image-01.png)

![My Image](readme-images/image-02.png)

![My Image](readme-images/image-03.png)

![My Image](readme-images/image-04.png)

![My Image](readme-images/image-05.png)

![My Image](readme-images/image-06.png)

![My Image](readme-images/image-07.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **security** in **MVC (Thymeleaf)** application using **Keycloak** tool with usage **Java** programming language and **Spring Boot 3** framework. Security is based on authorization grant type **Authorization Code**. This application handles **users** with roles. User has access to only specific secured resouce after log in.

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
* **Authorization Code Grant**: it is an OAuth 2.0 flow used for securely obtaining an access token. It is commonly used by web and mobile apps that need to authenticate users via a third-party authorization server.


USAGES
------

This project can be tested in following configurations:
* **Usage Docker Compose**: all services are started as Docker containers definied in docker compose file.


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
1. In a browser visit **Keycloak** console with `http://localhost:8080`
   * Use credentials admin/admin and create new User (Name: "user", Credentials: "user". Please check section **Keycloak Configuration**)
1. In a browser visit **MVC** with `http://localhost:9090`
    * Expected Landing page
    * Click **Public Page**: expected public page
    * Click **Secured Page**: expected secured page after log in (credentials user/user)
1. Clean up environment 
     * In a command line tool **remove Docker containers** with `docker-compose down --rmi all`
     * Stop **Docker** tool

##### Optional steps:
1. In a command line tool validate Docker Compose with `docker-compose config`
1. In a command line tool check list of Docker images with `docker images`
1. In a command line tool check list of all Docker containers with `docker ps -a`
1. In a command line tool check list of active Docker containers with `docker ps`
1. In a command line tool check list of Docker nerworks with `docker network ls`
1. In a command line tool check BE container logs with `docker logs be-container`
1. In a command line tool check FE container logs with `docker logs fe-container`


IMPLEMENTATION
--------------

After export you have to **update realm-export.json** file:
* "type": "regex" (instead of "js")
* "secret": "helloworld-secret" (insetead of "********")


KEYCLOAK CONFIGURATION
----------------------

![My Image](readme-images/config-01.png)

![My Image](readme-images/config-02.png)

![My Image](readme-images/config-03.png)

![My Image](readme-images/config-04.png)

![My Image](readme-images/config-05.png)

![My Image](readme-images/config-06.png)

![My Image](readme-images/config-07.png)

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