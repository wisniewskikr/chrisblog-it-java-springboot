USAGE
-----

Usage steps:
1. Start application with `mvn spring-boot:run`
1. Send GET request with Postman to URL `http://localhost:8080`
1. Send GET request with Postman to URL `http://localhost:8080/user?user=user&password=user123`
1. Send GET request with Postman to URL `http://localhost:8080/user?user=admin&password=admin123`
1. Send GET request with Postman to URL `http://localhost:8080/admin?user=admin&password=admin123`
1. Clean up environment:
    * Stop application with `ctrl + C`

![My Image](image-1.png)

![My Image](image-2.png)

![My Image](image-3.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **authentication and authorization** in **Java** application type **API** with usage **Spring Boot** framework and **Spring Security** dependencies. Secured resources are displayed after **one request**. Credentials are sent as **URL Parameters**. **Authentication** is done manually by developer in **filter** (if everything is ok then object **SecurityContextHolder** with user **roles** is created). **Authorization** is done automatically by Spring Security based on **cofiguration** (paths and roles).

##### Flow
The following flow takes place in this project:
1. User uses any Client API (for instance Postman) for sending GET request to Server for not secured content. 
1. Server sends back not secured content to Client API
1. Client API displays not secured content to the User 
1. User uses any Client API for sending GET request to Server for secured content for role USER. Credentials type JSON are sent together with this request
1. Server checks if credentials are valid. If everything is ok secured content for role USER is sent back to Client API
1. Client API displays secured content for role USER to the User
1. User uses any Client API for sending GET request to Server for secured content for role ADMIN. Credentials type JSON are sent together with this request
1. Server checks if credentials are valid. If everything is ok secured content for role ADMIN is sent back to Client API
1. Client API displays secured content for role ADMIN to the User  

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Security**: `https://docs.google.com/document/d/1nhPRbfD10KJOYsgI1HUwUz95ReiJPbXK85_zMyAptoY/edit?usp=sharing`
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 17.0.5)
* Installed **Maven** (tested on version 3.8.5)
* Installed **Git** (tested on version 2.33.0.windows.2)
* Installed **Postman** (tested on version 8.11.1)

##### Preconditions - Actions
* **Download** source code using Git 
* * Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder**. Type commands from section **USAGE** there.