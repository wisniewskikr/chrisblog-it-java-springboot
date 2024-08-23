USAGE
-----

Required steps:
1. `docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=my_secret_password -e MYSQL_DATABASE=database -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin123 -p 3306:3306 mysql:5.7`
1. In the first command line tool start Back-End application with `mvn -f ./fe-thymeleaf-be-springboot-db-sql-mysql_BE spring-boot:run`
1. In the second command line tool start Front-End application with `mvn -f ./fe-thymeleaf-be-springboot-db-sql-mysql_FE spring-boot:run`
1. Visit `http://localhost:8080`
1. Clean up environment:
    * In the first Command Line with `ctrl + C`
    * In the second Command Line with `ctrl + C`

Optional steps:
1. In a browser check Back-End application with `http://localhost:8081`
1. In a command line tool check Docker images with `docker images`
1. In a command line tool check Docker containers with `docker ps`


USAGE COMMANDS
--------------

> Please be aware that following tools should be installed on your local PC: **Java**, **Maven** and **Git**. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In a command line tool start application with `mvn spring-boot:run`
1. In a http client tool (e.g. Postman) read all posts using **GET** method and url `http://localhost:8080/api/posts`
   * Expected list of posts
1. In a http client tool (e.g. Postman) read single post using **GET** method and url `http://localhost:8080/api/posts/1`
   * Expected post with id 1
1. In a http client tool (e.g. Postman) create single post using **POST** method and url `http://localhost:8080/api/posts`
   * Please set up **Body** as following **JSON**:
   ```
   {
    "userId": 1,
    "title": "Title",
    "body": "Body"
   }
   ```
   * Expected post with new id
1. In a http client tool (e.g. Postman) update single post using **PUT** method and url `http://localhost:8080/api/posts/1`
   * Please set up **Body** as following **JSON**:
   ```
   {
    "userId": 2,
    "title": "Title Updated",
    "body": "Body Updated"
   }
   ```
   * Expected updated post
1. In a http client tool (e.g. Postman) delete single post using **DELETE** method and url `http://localhost:8080/api/posts/1`
   * Expected empty response
1. Clean up environment 
     * In a command line tool stop application with `ctrl + C`


USAGE IMAGES
------------

![My Image](readme-images/image-01.png)

![My Image](readme-images/image-02.png)

![My Image](readme-images/image-03.png)

![My Image](readme-images/image-04.png)

![My Image](readme-images/image-05.png)


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