DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **Server Authentication** between two applications connected by **API** type **Web Client** using **SSL** definied in **System Properties**. The result is **Hello World** message and **port** numbers of **Client** and **Server** services in a **JSON** format in a **browser** using **Java** applications with **Spring Boot** framework.

##### Details
This project consists of two applications:
* **Client**: this application is called **Display**. It displays text message and ports of Client and Server
* **Server**: this application is called **Text**. It provides text message to Client

In this project Server application uses Server Authentication to authenticate itself (so called SSL). It means that during communication Server confirms its identity by certificate and Client can be 100% sure that connects with trusted Server.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: details - `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Security**: details - `https://docs.google.com/document/d/1nhPRbfD10KJOYsgI1HUwUz95ReiJPbXK85_zMyAptoY/edit?usp=sharing`
* **SSL**: details - `https://docs.google.com/document/d/1h7vqQeMWD_QG09ymEmec3JmEtkChMwnkm2mgdhh81Bk/edit?usp=sharing`
* **Self-Signed Keystore and Truststore**:
     * **Generate Keystore** with `keytool -genkeypair -keyalg RSA -keysize 2048 -alias spring -dname "CN=myname,OU=myunit,O=myorg,C=PL" -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -validity 3650 -keystore keystore.p12 -storepass secret -keypass secret -storetype PKCS12`
     * **Export certificate** with `keytool -export -alias spring -keystore keystore.p12 -file mycert.cer`
     * **Generate Truststore and import certificate** with `keytool -import -alias spring -keystore truststore.p12 -file mycert.cer -storetype PKCS12`


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
    * Go to source code folder with `cd chrisblog-it\java-springboot-security-server-authentication\springboot-communication-common-system-ssl`


USAGE
-----

Usage steps:
1. In the first Command Line tool start application with `mvn -f ./springboot-helloworld-browser-json-ports-text spring-boot:run`
2. In the second Command Line tool start application with `mvn -f ./springboot-helloworld-browser-json-ports-display spring-boot:run`
3. Visit `http://localhost:8080`
4. Clean up environment:
    * In the first Command Line with `ctrl + C`
    * In the second Command Line with `ctrl + C`