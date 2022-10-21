DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **communication** between two applications using **not blocked WebClient**. The result is **Hello World** message and **port** numbers of **Text** and **Display** services in a **JSON** format in a **browser** using **Java** applications with **Spring Boot** framework.

##### Details
Three the most important ways of communication between applications in Spring Boot are:
* **RestTemplate**: synchronous communication
* **WebClient**: synchronous and asynchronous communication
* **OpenFeing**: related to Spring Cloud

WebClient handles two types of responses:
* **mono**: single class is returned;
* **flux**: collection of classes is returned.

WebClient can be also:
* **not blocked**: asynchronous communication. Code execution is not blocked by WebClient - execution doesn't wait for finishing WebClient task;
* **blocked**: synchronous communication. Code execution is blocked by WebClient - execution waits for finishing WebClient task.
 
In this example - not blocked WebClient - text is displayed before communication with Text service is finished. Text service has implemented 5 seconds delay. So in Display service logs first is displayed message from Display service and after 5 seconds message from Text service. The application displays message "Hello World from Display!" and "port" number of Display service in JSON format in a browser.

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
* **Download** source code and open any **Command Line** tool on **project's folder**. You can do it in following way:
    * Open any Command Line tool (for instance "Windonw PowerShell" on Windows OS) and go to folder where you want to download source code 
    * Clone Github repository with `git clone https://github.com/wisniewskikr/chrisblog-it.git`
    * Go to source code folder with `cd chrisblog-it\java-springboot-communication\springboot-communication-webclient-blocked-no`


USAGE
-----

Usage steps:
1. In the first Command Line tool start application with `mvn -f ./springboot-helloworld-browser-json-ports-text spring-boot:run`
1. In the second Command Line tool start application with `mvn -f ./springboot-helloworld-browser-json-ports-display spring-boot:run`
1. Visit `http://localhost:8080`
1. Check Display service logs. First should be diplayed "Hello World" message from Display service and after 5 seconds message from Text service
1. Clean up environment:
    * In the first Command Line with `ctrl + C`
    * In the second Command Line with `ctrl + C`