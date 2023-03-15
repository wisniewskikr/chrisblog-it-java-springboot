CRIPTION
-----------

##### Goal
The goal of this project is to present how to create **Hello World** application in **Java** programming language with usage **Spring Boot** framework which handles **transactions** and **propagation** type **REQUIRED**.
 
**Transaction** means that all database operations should be performed or none of them. There can not be such situation that some databases operations are performed and some not. In Spring Boot transactions are handled by annotation **@Transactional** (in this example classes SentenceService and WordService).

**Propagation** takes place when we have two or more methods marked as @Transactional which calls each other. In such a situation there is a question about the relation between transactions. Should all transactions be treated as one? Should all transactions be treated as separate transactions? 

In Spring Boot propagation is handled by annotation **@Transactional(propagation = Propagation.{propagation-type})**.

Types of propagation:
* **REQUIRED**: this is the default type of propagation in Spring Boot. This type of propagation means that all methods marked as @Transactional are treated as one transaction. So if some error occurs in one of them then operations are rolled back in all of them;
* **REQUIRES NEW**: this type of propagation means that method marked with this type suspends previous transaction and creates new one. So if some error occurs in this method then all operations in this method are rolled back but not in previous methods
* **MANDATORY**: method marked with this type of propagation has to be called from a transactional method. Otherwise an exception is thrown.
* **NEVER**: method marked with this type of propagation can not be called from a transactional method. Otherwise an exception is thrown.
* **SUPPORTS**: method marked with this type of propagation joins existing transactions. If there is no transaction the it doesn’t create new one 
* **NOT SUPPORTED**: method marked with this type of propagation suspends existing transaction - everything in this method is not transactional

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application HelloWorld for content
1. Application HelloWorld runs transactional method saveSentence(Hello, World) which calls two methods: saveFirstWord(Hello) and saveSecondWord(World). There is an exception in saveSecondWord(World) which is also transactional and marked as Propagation.REQUIRED. So all database operations are rolled back - even already saved word "Hello". That's why sentence from database is 'null null'. Description and sentence are added to result JSON
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