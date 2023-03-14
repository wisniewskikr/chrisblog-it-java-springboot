CRIPTION
-----------

##### Goal
The goal of this project is to present how to create **Hello World** application in **Java** programming language with usage **Spring Boot** framework which handles **transactions** and **propagation** type **NOT_SUPPORTED**.
 
**Transaction** means that all database operations should be performed or none of them. There can not be such situation that some databases operations are performed and some not. In Spring Boot transactions are handled by annotation **@Transactional** (in this example classes SentenceService and WordService).

**Propagation** is used when first transactional method calls second transactional method. Type **NOT_SUPPORTED** means that If a current transaction exists, first Spring suspends it, and then the business logic is executed without a transaction. In Spring Boot transactions this propagation is handled by annotation **@Transactional(propagation = Propagation.NOT_SUPPORTED)** (in this example class WordService).

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application HelloWorld for content
1. Application HelloWorld runs transactional method saveSentence(Hello, World) which calls two methods: saveFirstWord(Hello) and saveSecondWord(World). There is an exception in saveSecondWord(World) which is transactional and marked as Propagation.NOT_SUPPORTED. So because second method does not support transactions then operations inside this method ARE NOT rolled back. That's why sentence from database is: 'Hello World'. Description and sentence are added to result JSON
1. Application HelloWorld returns response with JSON. This response is presented to User via browser

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


PRECONDITIONS
-------------
##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`

##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-java`)


USAGE
-----

Usage steps:
1. Start application with `mvn spring-boot:run`
1. Visit `http://localhost:8080`
1. (Optional) Check database in console (url: "jdbc:h2:mem:db-embedded", user: "admin", password: "admin123") with `http://localhost:8080/console`
1. Clean up environment with `ctrl + C`