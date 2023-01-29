DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to display **Hello World** message in a **browser** by **Java** application using **Spring Boot** framework and **Docker** tool. It presents following Docker tool features:
* **Slow Build Image** (but it does not require locally installed Java and Maven) basing on **Dockerfile** and run Container on local computer
* **Fast Build Image** (but it requires locally installed Java and Maven) basing on **Dockerfile-Fast** and run Container on local computer
* Build Image basing on Dockerfile and **push** it to Remote Repository
* **Pull** Image from Remote Repository and run Container on local computer

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application HelloWorld for content.
1. Application HelloWorld returns response with message. This response is presented to User via browser.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker**: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`


PRECONDITIONS
-------------
##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* Installed **Docker** (tested on verison 20.10.21). Tool details: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`

##### Preconditions - Actions
* Launch Docker tool on your local machine
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-docker`)


USAGE - FAST BUILD IMAGE AND RUN CONTAINER LOCALLY (FAST BUT REQUIRES LOCALLY INSTALLED JAVA AND MAVEN)
-------------------------------------------------------------------------------------------------------

Usage steps:
1. Build package with `mvn clean package -Dmaven.test.skip`
1. Build image with **docker build -t {image-name} .** . For instance with `docker build -f Dockerfile-Fast -t springboot-helloworld-docker-image .`
1. Build and start container with **docker run -d -p {port}:{port} --name {container-name} {image-name}**. For instance with `docker run -d -p 8080:8080 --name springboot-helloworld-docker-container springboot-helloworld-docker-image`
1. Visit `http://localhost:8080`
1. Display container logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs springboot-helloworld-docker-container`
    * Stop displaying logs with `ctrl + c`
1. Clean up environment:

    * Stop container with **docker stop {container-name}**. For instance with `docker stop springboot-helloworld-docker-container`
    * Remove container with **docker rm {container-name}**. For instance with `docker rm springboot-helloworld-docker-container`
    * Remove image with **docker rmi {image-name}**. For instance with `docker rmi springboot-helloworld-docker-image`
    

USAGE - SLOW BUILD IMAGE AND RUN CONTAINER LOCALLY (SLOW BUT DOES NOT REQUIRE LOCALLY INSTALLED JAVA AND MAVEN)
---------------------------------------------------------------------------------------------------------------

Usage steps:
1. Build image with **docker build -t {image-name} .** . For instance with `docker build -t springboot-helloworld-docker-image .`
1. Build and start container with **docker run -d -p {port}:{port} --name {container-name} {image-name}**. For instance with `docker run -d -p 8080:8080 --name springboot-helloworld-docker-container springboot-helloworld-docker-image`
1. Visit `http://localhost:8080`
1. Display container logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs springboot-helloworld-docker-container`
    * Stop displaying logs with `ctrl + c`
1. Clean up environment:

    * Stop container with **docker stop {container-name}**. For instance with `docker stop springboot-helloworld-docker-container`
    * Remove container with **docker rm {container-name}**. For instance with `docker rm springboot-helloworld-docker-container`
    * Remove image with **docker rmi {image-name}**. For instance with `docker rmi springboot-helloworld-docker-image`

    
USAGE - BUILD IMAGE AND PUSH IT TO REMOTE REPOSITORY
----------------------------------------------------

Usage steps:
1. Build package with `mvn clean package`
2. Build image with **docker build -t {image-name} .** . For instance with `docker build -f Dockerfile-Fast -t springboot-helloworld-docker-image .`
3. Tag image with **docker tag {image-name} {docker-id}/{image-name}**. For instance with `docker tag springboot-helloworld-docker-image wisniewskikr/springboot-helloworld-docker-image`
4. Push image to remote repository with **docker push {docker-id}/{image-name}** . For instance with `docker push wisniewskikr/springboot-helloworld-docker-image`
5. Check remote repository with `https://hub.docker.com`. Log in to your **docker-id** account and check that image with **{image-name}** exists there. For instance `springboot-helloworld-docker-image`
6. Clean up environment:

    * Remove tagged image with **docker rmi {docker-id}/{image-name}**. For instance with `docker rmi wisniewskikr/springboot-helloworld-docker-image`
    * Remove image with **docker rmi {image-name}**. For instance with `docker rmi springboot-helloworld-docker-image`
    * Remove image with name **{image-name}** from your **docker-id** remote repository `https://hub.docker.com`. For instance `springboot-helloworld-docker-image`.


USAGE - PULL IMAGE FROM REMOTE REPOSITORY AND RUN CONTAINER LOCALLY
-------------------------------------------------------------------

Usage steps:
1. Pull image from remote repository with **docker pull {docker-id}\{image-name}**. For instance with `docker pull wisniewskikr\springboot-helloworld-docker-image`
2. Start container with **docker run -d -p {port}:{port} --name {container-name} {docker-id}/{image-name}**. For instance with `docker run -d -p 8080:8080 --name springboot-helloworld-docker-container wisniewskikr/springboot-helloworld-docker-image`
3. Visit `http://localhost:8080`
4. Display container logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs springboot-helloworld-docker-container`
    * Stop displaying logs with `ctrl + c`
5. Clean up environment:

    * Stop container with **docker stop {container-name}**. For instance with `docker stop springboot-helloworld-docker-container`
    * Remove container with **docker rm {container-name}**. For instance with `docker rm springboot-helloworld-docker-container`
    * Remove image with **docker rmi {docker-id}/{image-name}**. For instance with `docker rmi wisniewskikr/springboot-helloworld-docker-image`


DOCKER - BASIC COMMANDS
-----------------------

* **docker build -t <image> .**: build image based on Docker file located in current folder. Pay attention to the dot at the end of command. For instance: `docker build -t demo-image .`
* **docker run -p <port> –name <container> <image>**: run container based on image. Pay attention that before “name” are two dashes. For instance: `docker run -p 8080:8080 –name demo-container demo-image` 
* **docker stop <container>**: stops specific container. For instance: `docker stop demo-container`
* **docker rm <container>**: removes specific container. For instance: `docker rm demo-container`
* **docker tag <image_source> <image_target>**: creates tag for image. For instance: `docker tag demo-image wisniewskikr/demo-image`
* **docker push <image>**: pushes specific image to Docke Hub. For instance: `docker push wisniewskikr/demo-image`
* **docker rmi <image>**: removes specific image. For instance: `docker rmi demo-image`


DOCKER - BASIC COMMANDS OF IMAGE
--------------------------------

* **docker images**: list of all images on local computer;
* **docker pull <image>**: pull image from Docker Hub. For instance: `docker pull alpine`
* **docker push <image>**: push image to Docker Hub. You have to have write access to this Hub. For instance: `docker push wisniewskikr/demo`
* **docker rmi <image>**: remove image with specific id. For instance: `docker rmi 123`
* **docker rmi -f $(docker images -a -q)**: remove all images from local machine
* **docker build -t <image> .**: build image based on Docker file located in current folder. Pay attention to the dot at the end of command. For instance: `docker build -t demo .`
* **docker tag <image_source> <image_target>**: creates tag for image. For instance: `docker tag demo wisniewskikr/demo`


DOCKER - BASIC COMMANDS OF CONTAINER
------------------------------------

* **docker ps**: displays list of all running containers;
* **docker ps -a**: displays list of all containers;
* **docker run -p <port> --name <container> <image>**: run container based on image. Pay attention that before “name” are two dashes. For instance: `docker run -p 8080:8080 --name demo-container demo-image`
* **docker run -p <port> --name <container> -e “<parameters>” <image>**: run container based on image with some custom parameters. Pay attention that before “name” are two dashes. For instance: `docker run -p 8080:8080 --name demo-container -e "JAVA_OPTS=-Dsome.property=value -Xmx1024m" demo-image`
* **docker start <container>**: starts specific container. For instance: `docker start demo-container`
* **docker stop <container>**: stops specific container. For instance: `docker stop demo-container`
* **docker rm <container>**: removes specific container. For instance: `docker rm demo-container`
* **docker logs <container>**: displays logs of specific containers. For instance: `docker log demo-container`
* **docker inspect <container>**: details of container. For instance: `docker inspect demo-container`


DOCKER - BASIC COMMANDS OF NETWORK
----------------------------------

* **docker network ls**: displays list of all networks;
* **docker network create <network>**: creates specific network. For instance: `docker network create demo-network` 
* **docker network rm <network>**: removes specific network. For instance: `docker network rm demo-network`
* **docker network rm $(docker network ls | tail -n+2 | awk '{if($2 !~ /bridge|none|host/){ print $1 }}')**: removes all networks;
* **docker run --network <network> --name <container> -p <port> <image>**: run container in specific network. For instance: `docker run --network demo-network --name demo-container -p 8080:8080 demo-image`


DOCKER - OTHER BASIC COMMANDS
-----------------------------

* **docker**: displays all available commands;
* **docker <command> --help**: displays description of specific command. For instance: `docker run --help`
* **docker version**: displays version of docker;
* **docker kill <container>**: immediately stops container. For instance: `docker kill demo-container`
* **docker system prune**: removes all unused images, containers etc.
* **docker exec -it <container> <command>**: runs some command on specific container. For instance: `docker exec -it busybox ls`