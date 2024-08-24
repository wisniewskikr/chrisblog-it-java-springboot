EXAMPLE
-------

![My Image](readme-images/image-01.png)


USAGE CLASSIC
-------------

> **Usage Classic** means that Back-End and Front-End servers are started manually by developer from a command line. Database is provided as Docker container.

> Please be aware that following tools should be installed on your local PC: **Java**, **Maven** **Git** and **Docker**. Docker has to be **up and running**. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Required steps:
1. In the first command line tool start MySql database with `docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=my_secret_password -e MYSQL_DATABASE=database -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin123 -p 3306:3306 mysql:5.7`
1. In the second command line tool start Back-End application with `mvn -f ./fe-thymeleaf-be-springboot-db-sql-mysql_BE spring-boot:run`
1. In the third command line tool start Front-End application with `mvn -f ./fe-thymeleaf-be-springboot-db-sql-mysql_FE spring-boot:run`
1. In a browser visit `http://localhost:8080`
   * Expected HTML page with **Message from Database**, **Id of Back-End**, **Port of Back-End**, **Id of Front-End** and **Port of Front-End** 
1. Clean up environment 
     * In the third command line tool stop Front-End application with `ctrl + C`
     * In the second command line tool stop Back-End application with `ctrl + C`
     * In the first command line tool stop and remove Docker container with `docker rm -f mysql-container`
     * In the first command line tool remove Docker image with `docker rmi mysql:5.7`

Optional steps:
1. In a browser check Back-End application with `http://localhost:8081/message/1`
1. In a command line tool check list of Docker images with `docker images`
1. In a command line tool check list of all Docker containers with `docker ps -a`
1. In a command line tool check list of active Docker containers with `docker ps`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use **RestClient** for communication in an application type **API REST** in **Java** programming language with usage **Spring Boot** framework. RestClient is HTTP Client introduced in Spring Boot from version 3.2. It connects advantages of two other HTTP Clients provided by Spring Boot: RestTemplate and WebClient.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **API REST**: an architectural style for an application program interface (API) that uses HTTP requests to access and use data
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Maven**: tool for build automation
* **Git**: tool for distributed version control

##### Flow
The following flow takes place in this project:
1. User via any http client sends requests to application for post. These request are RESTFUL.
1. Application uses RestClient to get responses from external API
1. Application sends back response to User via http client.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* **Spring Boot**: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 11)
* Installed **Java** (tested on version 17.0.5)
* Installed **Maven** (tested on version 3.8.5)
* Installed **Git** (tested on version 2.33.0.windows.2)


##### Preconditions - Actions
* Download **Source Code** (using Git or in any other way) 
* Open any **Command Line** tool (for instance "Windonw PowerShell" on Windows OS) on downloaded **project's main folder**