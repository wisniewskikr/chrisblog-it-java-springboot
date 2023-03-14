DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement applications in **Java** programming language with usage **Spring Boot** framework which will **communicate** each other using **retrofit** library.

##### Applications
This project consists of following applications:
* **Display**: port **8080**. This application displays result of whole system
* **Text**: port **9090**. This application provides text to application Display

##### Flow
The following flow takes place in this project:
1. User via browser sends request to application Display for content
1. Application Display sends request to application Text for content
1. Applications Text sends back response to application Display with text and port
2. Application Display sends back response to User via browser with text, Display port and Text port

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: framework details: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`

##### Preconditions - Actions
* **Download** source code and open any **Command Line** tool on **project's folder**. Project you can find on Github repository: `https://github.com/wisniewskikr/chrisblog-it-java`


USAGE
-----

Usage steps:
1. In the first Command Line tool start application with `mvn -f ./springboot-helloworld-browser-json-ports-text spring-boot:run`
2. In the second Command Line tool start application with `mvn -f ./springboot-helloworld-browser-json-ports-display spring-boot:run`
3. Visit `http://localhost:8080`
4. Clean up environment:
    * In the first Command Line with `ctrl + C`
    * In the second Command Line with `ctrl + C`