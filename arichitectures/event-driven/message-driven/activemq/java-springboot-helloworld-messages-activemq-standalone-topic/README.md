USAGE JAVA
----------

> Please be aware that following tools should be installed on your local PC: **Java**, **Maven**, **Git**, **Docker** and **Docker Compose**. Tools **Docker** and **Docker Compose** should be up and running. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In a command line tool start standalone ActiveMq with `docker-compose up -d`
1. In a command line tool start application with `mvn spring-boot:run`
1. In a first tab of browser subscribe message with `http://localhost:8080/subscribe`
     * Expected: subscriber is waiting for message
1. In a second tab of browser publish
 message with `http://localhost:8080/publish`
1. Result:
     * Listener: In a command line tool expected message: "Topic was subscribed successfuly by Listener. Message: Hello World!"
     * Consumer: In a subscriber tab of browser expected message: "Topic was subscribed successfuly by Subscriber. Message: Hello World!"
1. Clean up environment 
     * In a command line tool stop application with `ctrl + C`
     * In a command line tool stop and remove standalone ActiveMQ with `docker-compose down`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to send **JMS messages** type **Topic** between applications in **Java** programming language with usage **Spring Boot** framework and **standalone ActiveMQ** message broker.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Maven**: tool for build automation
* **Git**: tool for distributed version control
* **JMS messages type Topic**: it's asynchronic communication type publish-subscribe. It means that published message is subscribed by all Subscribers at the same time
* **ActiveMQ**: message broker between publisher and subscriber. Standalone means that message broker is external tool installed on computer
* **Docker**: tool for developing, shipping, and running applications which are provided as Docker Images and run as Docker Containers
* **Docker Compose**: tool for defining and sharing Docker multi-container applications


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
* **Docker**: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`
* **Docker Compose**: `https://docs.google.com/document/d/1SPrCS5OS_G0je_wmcLGrX8cFv7ZkQbb5uztNc9kElS4/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 11)
* Installed **Java** (tested on version 17.0.5)
* Installed **Maven** (tested on version 3.8.5)
* Installed **Git** (tested on version 2.33.0.windows.2)
* Installed **Docker** (tested on version 20.10.23)
* Installed **Docker Compose** (tested on version v2.15.1)


##### Preconditions - Actions
* Download **Source Code** (using Git or in any other way) 
* Open any **Command Line** tool (for instance "Windonw PowerShell" on Windows OS) on downloaded **project's main folder**