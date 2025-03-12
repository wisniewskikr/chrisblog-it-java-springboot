EXAMPLE
-------

![My Image](readme-images/image-01.png)

![My Image](readme-images/image-02.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to perform **backup** of **MySql** dababase basing on application in **Java** programming language with usage **Spring Boot** framework. Backup means that database is loaded with data from "backup.sql" file.

##### Elements
This project consists of following elements:
* **MVC**: this application consists of:
     * Single page which displays "Hello World" message from MySql database

##### Terminology
Terminology explanation:
* **Git**: tool for distributed version control
* **Maven**: tool for build automation
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **MVC**: MVC is a design pattern that separates an application into three components: 1. Model: Manages data and business logic. 2. View: Handles UI and presentation (Thymeleaf templates in Spring Boot). 3. Controller: Processes user requests, interacts with the model, and updates the view.
* **MySql**: MySQL is an open-source relational database management system (RDBMS) that uses SQL (Structured Query Language) to store, manage, and retrieve data. It is widely used for web applications, data warehousing, and enterprise solutions due to its speed, reliability, and ease of use.


USAGE
-----

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**.

> **Prerequisites**:  
* **Operating System** (tested on Windows 11)
* **Git** (tested on version 2.33.0.windows.2)
* **Docker** (tested on version 4.33.1)

##### Required steps:
1. Start **Docker** tool
1. Start database with `docker-compose up -d`
1. Start application with `mvn spring-boot:run`
1. Visit `http://localhost:8080`
1. Clean up local environment 
     * Stop application `ctrl + C`
     * Stop database and console with `docker-compose down`
     * Stop Docker tool

##### Optional steps:
1. Create MySql backup file with `docker exec -i <mysql-container-name> mysqldump -u root -p<password> <database_name> > backup.sql`