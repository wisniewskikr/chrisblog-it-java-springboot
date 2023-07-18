USAGE
-----

> **Note** Please be aware that this example requires tool **grpcurl**. For more details please check section **Preconditions**.

Usage steps:
1. In first Command Line tool build Grpc API classes basing on **HelloWorld.proto** file with `mvn clean install`
1. In first Command Line tool start application with `mvn spring-boot:run`
1. In second Command Line tool play with API:
     * Call application with `grpcurl --plaintext -d '{"name": "Chris"}' localhost:6565 HelloWorldService/GetHelloWorld`
     * (Optional) Display list of endpoints with `grpcurl --plaintext localhost:6565 list`
     * (Optional) Display list of methods in specific endpoint with `grpcurl --plaintext localhost:6565 list HelloWorldService`
1. (Optional) In IDE run class **HelloWorldClient** and method **main()**     
1. In first Command Line tool clean up environment with `ctrl + C`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **Java** application type **GRCP API** with usage **Spring Boot** framework.

##### Flow
The following flow takes place in this project:
1. User via tool grpcurl sends request to application for a content. GRCP API is used for communication.
1. Application sends back response to User via tool grpcurl. GRCP API is used for communication.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 11)
* Installed **Java** (tested on version 17.0.5)
* Installed **Maven** (tested on version 3.8.5)
* Installed **Git** (tested on version 2.33.0.windows.2)
* Installed **grpcurl**: recommended installation steps on Windows:
     * Install tool **GO** with `https://go.dev/doc/install`
     * Install tool **grpcurl** using pre-installed GO with `go install github.com/fullstorydev/grpcurl/cmd/grpcurl@latest`

##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on the main **project's folder**.