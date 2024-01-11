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


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to create an application type **API REST** in **Java** programming language with usage **Spring Boot** framework.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **API REST**: an architectural style for an application program interface (API) that uses HTTP requests to access and use data
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Maven**: tool for build automation
* **Git**: tool for distributed version control

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application Hello World for the content.
1. Application HelloWorld sends back response with JSON containing: message, port and UUID. This response is presented to User via browser.

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