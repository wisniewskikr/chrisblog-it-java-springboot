USAGE COMMANDS
--------------

> Please be aware that following tools should be installed in advance on your computer: **Java**, **Maven** and **Git**. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In a command line tool start application with `mvn spring-boot:run`
1. In a html browser (e.g. Chrome) visit `http://localhost:8080/v3/api-docs`
   * Expected **JSON with API documentation**
1. In a html browser (e.g. Chrome) visit `http://localhost:8080/swagger-ui/index.html`
   * Expected **GUI** for API
1. Clean up environment 
     * In a command line tool stop application with `ctrl + C`


USAGE IMAGES
------------

Start application:

![My Image](images/image-01.png)

Display result:

![My Image](images/image-02.png)

![My Image](images/image-03.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **Swagger 3 (OpenAPI 3.0)** in an application type **API REST** in **Java** programming language with usage **Spring Boot** framework. Swagger 3 provides **documentation** and **GUI** interface for API - user can play with API using web browser.

##### Terminology
Terminology explanation:
* **Java**: Java is a widely-used programming language for coding web applications.
* **API REST**: an architectural style for an application program interface (API) that uses HTTP requests to access and use data
* **Spring Boot**: Java Spring Framework (Spring Framework) is a popular, open source, enterprise-level framework for creating standalone, production-grade applications that run on the Java Virtual Machine (JVM).
* **Swagger 3 (OpenAPI 3.0)**: The OpenAPI Specification (OAS) defines a standard, language-agnostic interface to HTTP APIs which allows both humans and computers to discover and understand the capabilities of the service without access to source code or documentation. 

##### Flow
The following flow takes place in this project:
1. User via any html browser can receive API documentation in JSON format.
1. User via any html browser can play with API.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`


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