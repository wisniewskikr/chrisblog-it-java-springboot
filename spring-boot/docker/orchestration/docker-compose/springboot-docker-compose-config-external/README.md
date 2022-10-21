DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use external configuration file in simple "Hello World" Java Spring Boot application using Docker Compose tool.


##### Details
* External configuration means that configuration file is not included in application. It's very flexible solution because developer can very easly update configuration files
* This example application just displays text: "Hello World". This text is stored in `application.properties` file. But this file is not in resources so Spring Boot does not see it by default. You have to mount it using Docker `volume` attribute 
* More information about Docker Compose tool you can find here: `https://docs.google.com/document/d/1SPrCS5OS_G0je_wmcLGrX8cFv7ZkQbb5uztNc9kElS4/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed Java
* Installed Maven
* Installed Git
* Installed Docker

##### Preconditions - Actions
* Download Source Code with `git clone https://github.com/wisniewskikr/java-springboot.git`
* Launch Docker tool on your local machine


USAGE
-----

1. Build package with `mvn clean package`
2. Start application with `docker-compose up -d --build`
3. Visit `http://localhost:8080`
4. Display container logs (optional)

    * Display logs with `docker logs greeting-container`
    * Stop displaying logs with `ctrl + c`
5. Clean up environment with `docker-compose down --rmi all`