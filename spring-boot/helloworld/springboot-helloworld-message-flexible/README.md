DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to **flexible** displays **Hello World** message in a **text** format in a **browser** using **Java** application with **Spring Boot** framework. The flexible message means that text is not hardcoded but **provided from outside the application** i.e. as command line variables.

##### Details
This application displays flexible "Hello World" message in browser. The message consists of following **variables**:
* **message_hello**: displayed as the word "Hello"
* **message_world**: displayed as the word "World"
* **message_exclamation**: displayed as the exclamation

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


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
    * Go to source code folder with `cd chrisblog-it\java-springboot\springboot-helloworld-message-flexible`


USAGE
-----

Usage steps:
1. Start application with **mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dmessage_hello={hello} -Dmessage_world={world} -Dmessage_exclamation={exclamation}"** . For instance with `mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dmessage_hello=Hello -Dmessage_world=World -Dmessage_exclamation=!"`
2. Visit `http://localhost:8080`
3. (Optional) Check health status (expected: **{"status":"UP"}** ) with `http://localhost:8080/actuator/health`
4. Clean up environment with `ctrl + C`