DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use external configuration file in simple "Hello World" Java Spring Boot application using Docker tool.


##### Details
* External configuration means that configuration file is not included in application. It's very flexible solution because developer can very easly update configuration files
* This example application just displays text: "Hello World". This text is stored in `application.properties` file. But this file is not in resources so Spring Boot does not see it by default. You have to mount it using Docker `volume` attribute 
* More information about Docker tool you can find here: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`


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
2. Build image with `docker build -t greeting-image .`
3. Build and start container with:
    * **GIT Console on Windows: ** `MSYS_NO_PATHCONV=1 docker run -d -p 8080:8080 -v ${PWD}/config/application.properties:/config/application.properties --name greeting-container greeting-image`
    * **Windows PowerShell:** `docker run -d -p 8080:8080 -v ${PWD}/config/application.properties:/config/application.properties --name greeting-container greeting-image`
4. Visit `http://localhost:8080`
5. Display container logs (optional)

    * Display logs with `docker logs greeting-container`
    * Stop displaying logs with `ctrl + c`
6. Clean up environment:

    * Stop container with `docker stop greeting-container`
    * Remove container with `docker rm greeting-container`
    * Remove image with `docker rmi greeting-image`