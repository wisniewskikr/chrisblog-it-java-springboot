DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to create Java application with usage **Spring Boot** framework and **asynchronous** methods returning **Future** class.

**Asynchronous** means that methods are not run one by one but parallelly. Spring Boot handles it by annotations **@EnableAsync** in configuration (class HelloWorldApplication) and **@Async** above asynchronous methods (class AsyncService).  

**Future** class means that developer can pause application`s workflow until asynchronous methods weren't be finished.

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application for a content.
1. Application HelloWorld calls asynchronous method runAsyncMethod(). It return Future response and workflow is paused until future operation is not done.
1. Application HelloWorld sends response with text "Hello World" to User via browser.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 11.0.16.1). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`


##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-java`)


USAGE
-----

Usage steps:
1. Start application with `mvn spring-boot:run`
2. Visit `http://localhost:8080`
3. Clean up environment with `ctrl + C`