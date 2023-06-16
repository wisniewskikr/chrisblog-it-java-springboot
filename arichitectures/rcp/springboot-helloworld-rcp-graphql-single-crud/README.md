USAGE
-----

Usage steps:
1. In any Command Line tool start application with `mvn spring-boot:run`
1. In any Browser open **GraphQL Console** with `http://localhost:8080/graphiql`
1. In GraphQL Console **create user**:
     * Run following GraphQL command:
         ```
         mutation {
          create(command: { name: "Chris" }) {
               id
               name
          }
        }
        ```
1. In GraphQL Console **view user**:
     * Run following GraphQL command:
         ```
         query {
          view(id: 1) {
               id
               name
          }
        }
        ```
1. In GraphQL Console **edit user**:
     * Run following GraphQL command:
         ```
         mutation {
          edit(id: 1, command: {name: "John"}) {
               id
               name
          }
        }
        ```
1. In GraphQL Console display **list of users**:
     * Run following GraphQL command:
         ```
         query {
          list {
               id
               name
          }
        }
        ```
1. In GraphQL Console **delete user**:
     * Run following GraphQL command:
         ```
         mutation {
          delete(id: 1)
        }
        ```
1. Clean up environment with `ctrl + C`


USAGE PRINTSCREENS
------------------

![My Image](images/image-01.png)

![My Image](images/image-02.png)

![My Image](images/image-03.png)

![My Image](images/image-04.png)

![My Image](images/image-05.png)


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **CRUD (Create, Read, Update, Delete)** operations in **Java** application type **GraphQL** with usage **Spring Boot** framework.

##### Flow
The following flow takes place in this project:
1. User via tool GraphiQL sends request to application for a content. Content can be type CRUD: Create, Read, Update or Delete
1. Application HelloWorld sends back response to User via tool GraphiQL.

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


##### Preconditions - Actions
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on the main **project's folder**.