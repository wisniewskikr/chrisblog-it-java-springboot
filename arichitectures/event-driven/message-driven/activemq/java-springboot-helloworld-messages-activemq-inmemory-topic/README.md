USAGE JAVA
----------

> Please be aware that following tools should be installed on your local PC: **Java**, **Maven** and **Git**. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In a command line tool start application with `mvn spring-boot:run`
1. In a first tab of browser subscribe message with `http://localhost:8080/subscribe`
     * Expected: subscriber is waiting for message
1. In a second tab of browser publish message with `http://localhost:8080/publish`
1. Result:
     * Listener: In a command line tool expected message: "Topic was subscribed successfuly by Listener. Message: Hello World!"
     * Subscriber: In a subscriber tab of browser expected message: "Topic was subscribed successfuly by Subscriber. Message: Hello World!"
1. Clean up environment 
     * In a command line tool stop application with `ctrl + C`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to send **JMS messages** type **Topic** between applications in **Java** programming language with usage **Spring Boot** framework and **in memory ActiveMQ** message broker.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Maven**: tool for build automation
* **Git**: tool for distributed version control
* **JMS messages type Topic**: it's asynchronic communication type publish-subscribe. It means that published message is subscribed by all Subscribers in the same time
* **ActiveMQ**: message broker between pubslishers and subscribers. In memory means that this tool is up and running together with application


##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application Hello World for sending JMS message.
1. Application sends JMS message to JMS Broker
1. Application sends back response to User via browser
1. JMS Broker sends message to all available Subscribers

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