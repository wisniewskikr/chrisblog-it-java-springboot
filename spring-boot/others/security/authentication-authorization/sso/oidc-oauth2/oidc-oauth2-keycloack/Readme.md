DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to **secure** Java Spring Boot application with **SSO type OpenId Connect (OIDC) and OAuth2** of vendor **Keycloack**. This application displays a simple form as **HTML** page in a **browser** using **Java** language with **Spring Boot** and **Thymeleaf** frameworks.

##### Details
SSO (Single Sign-On) allows a user to log in once - with a single ID - to many applications which are in the same SSO range. There are two types of SSO:
* SAML
* OIDC + OAuth2

This example presents SSO type OIDC and OAuth2 created by Keycloack. This SSO secures application. Before usage of application user is redirected to Login page. 
User has to use credentials to use application.

The application displays simple form as HTML page in a browser. This form consists of text field called "Name" and submit button. 
To use this application a user has to fill text field with his/her name and press submit button. The message "Hello World + {name}" will be displayed below the form.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: framework details: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **SSO**: `https://docs.google.com/document/d/1EdFyCYdAWRJlBJsqXcqVdPWf6tsMDJv0AovZ5Sm5BDc/edit?usp=sharing`


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
    * Go to source code folder with `cd chrisblog-it\java-springboot-iam\java-springboot-iam-sso-thymeleaf-saml-keycloack-apps-one`


USAGE
-----

Usage steps:
1. In the first Command Line tool start application with `mvn -f ./springboot-helloworld-thymeleaf-forms-simple spring-boot:run`
1. In the second Command Line tool start application with `mvn -f ./springboot-keycloack spring-boot:run`
1. (Optional) Visit Keykloack console (credentials **admin / pass**) with `http://localhost:8083/auth`
1. Visit (credentials **user@test.com / pass**) `http://localhost:8080`
1. Log out with pressing **Logout** link 
1. Clean up environment:
    * In the first Command Line with `ctrl + C`
    * In the second Command Line with `ctrl + C`