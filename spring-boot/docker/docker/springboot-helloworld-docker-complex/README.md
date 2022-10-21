DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to build and run simple "Hello World" Java Spring Boot application using Docker tool without building package in advance. User does not have to first build package and then run Docker commands. User can only run Docker commands and package will be built automatically. This approach has:
* **Pros**: simple usage. User does not have to remember about building package in advance;
* **Cons**: it's more time consuming. Docker installs Maven and downloads dependencies in image and it takes a lot of time.


##### Details
* More information about Docker tool you can find here: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`
* This example application just displays text: "Hello World"


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

1. Build image with `docker build -t greeting-image .`
2. Build and start container with `docker run -d -p 8080:8080 --name greeting-container greeting-image`
3. Visit `http://localhost:8080`
4. Display container logs (optional)

    * Display logs with `docker logs greeting-container`
    * Stop displaying logs with `ctrl + c`
5. Clean up environment:

    * Stop container with `docker stop greeting-container`
    * Remove container with `docker rm greeting-container`
    * Remove image with `docker rmi greeting-image`