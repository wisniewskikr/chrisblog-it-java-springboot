DESCRIPTION
-----------

##### Goal
The goal of this project is to show how to **send JMS messages** from one **Java** application with **Spring Boot** framework (called **Producer**) to other (called **Consumer**) using **Apache Kafka** JMS broker (type **Wurstmeister**). All applications are on different Docker containers managed by **Docker Compose** tool. This **full** and sophisticate example of using Apache Kafka with **many instances** of Zookeeper, Kafka, Producer and Consumer. 

##### Details
This project consists of following elements:
1. Two instances of Zookeepers;
2. Two instances of Kafka;
3. Two instances of Producers;
4. Three instances of Consumers.

**Ad 1. Two instances of Zookeepers**

Zookeeper is so called "Service Registry". It has information about location of all elements in an environment. It manages traffic in Kafka - when user sends some event then Zookeeper decides where this event should be redirected. Two Zookeepers does not mean that traffic is faster but it means that if one Zookeeper is down then other still works and whole environment still works.

**Ad 2. Two instances of Kafka**

Kafka is event's broker. It's a middle layer between Producers and Consumers. It handles such elements like partitioning (performance) or replication (security). In this example we have two instances of Kafka. It means that if one will be down then all data will be safe on second instance.

**Ad 3. Two instances of Producers**

Producer is an application which sends events to Consumers via Zookeeper and Kafka. This is Java application based on Spring Boot technology. In Producer you can configure following elements:
* **Topic**: Topic is some kind of "folder" for events; 
* **Topic`s Partition**: Partition is something like "subfolder" for Topic "folder". Goal of Partitions is to speed up performance of Kafka. Partitions for one Topic can be stored in many Kafka Clusters/Brokers. Topic with the same "key" should be stored in the same partition; 
* **Topic`s Replication**: Replication is copy of Partition. Goal of Replication to secure application against data lost. Every Replication is stored in separate Kafka Cluster/Broker. So it means that **count of Replications can not be heigher then count of Clusters/Brokers**;
* **Url**: Producer's Url consists of following variables (all not mandatory variables you can set as "null"):
     * **key**: it's id of event. All events with the same id are automatically stored in the same partition;
    * **value (mandatory)**: it's content of event;    
    * **timestamp**: it's timestamp of event. If it's null then current timestamp is automatically used; 
    * **partition**: it's number of partition where even should be stored. If it's null then partition is assigned automatically by Kafka.
    
In this example we have two instances of Producers:
* **Producer 1**: defined on port **8080** and connected with Topic **helloworld-man**. So this Producer should be used to send helloworld for a man. This Producer has also two partitions and two replications;
* **Producer 2**: defined on port **8081** and connected with Topic **helloworld-woman**. So This Producer should be used to send helloworld for a woman. This Producer has also two partitions and two replications.

**Ad 4. Three instances of Consumers**

Consumer is an application which consumes events sent by Producer via Zookeeper and Kafka. This is Java application based on Spring Boot technology. In Consumer you can configure following elements:
* **Topic**: which Topic should be consumed by this specific Consumer;
* **Group Id**: what is id of group this specific Consumer. If Consumers belong to the same group so that means that only one of them will consume one specific event. If Consumers doesn't belong to the same group so that means that every one of them will consume one specific event.
* **Event**: consumed event can consists of following elements:
    * **Topic**: name of topic;
    * **Group Id**: what is group id of Consumer which consumes this event;
    * **Offset**: what is delay of this event from the beginning;
    * **Key**: this is some kind of event's id;
    * **Partition**: what is partition of this event;
    * **Timestamp**: what is timestamp of this event;
    * **Message**: what is value of this event.

In this example we have three instances of Consumers:
* **Consumer 1**: consumes events connected with Topic **helloworld-man**. So all helloworlds for mans should be displayed here. This Consumer belongs to group **helloworld-man-woman**;
* **Consumer 2**: consumes events connected with Topic **helloworld-woman**. So all helloworlds for women should be displayed here. This Consumer belongs to group **helloworld-man-woman**;
* **Consumer 3**: consumes events connected with Topics **helloworld-man** and **helloworld-woman**. So all helloworlds should be displayed here. This Consumer belongs to group **helloworld-human**;

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker Compose** tool: `https://docs.google.com/document/d/1SPrCS5OS_G0je_wmcLGrX8cFv7ZkQbb5uztNc9kElS4/edit?usp=sharing`
* **Apache Kafka** tool: `https://docs.google.com/document/d/1pDBnFbpvo0mNaIgxLCV--3qUn-wf0vHZiTYRQL05Wes/edit?usp=sharing`

PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* Installed **Docker** (tested on version version 20.10.12). Tool details: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`

##### Preconditions - Actions
* **Download** source code and open any **Command Line** tool on **project's folder**. You can do it in following way:
    * Open any Command Line tool (for instance "Windonw PowerShell" on Windows OS) and go to folder where you want to download source code 
    * Clone Github repository with `git clone https://github.com/wisniewskikr/chrisblog-it.git`
    * Go to source code folder with `cd chrisblog-it\java-messages-kafka\springboot-kafka-wurstmeister-docker-compose-full`


USAGE
-----

Usage steps:
1. Build packages with `mvn clean package`
2. Start elements using Docker Compose with `docker-compose up --build`
3. Send messages (expected text **Done** in the browser) with **http://localhost:8080/helloworld/partition/{partition}/timestamp/{timestamp}/key/{key}/value/{value}** . For instance:
    * `http://localhost:8080/helloworld/partition/null/timestamp/null/key/helloworld/value/John`
    * `http://localhost:8081/helloworld/partition/null/timestamp/null/key/helloworld/value/Mary`
4. Read messages by checking logs in Command Line tool. Following message should be displayed there: **{consumer}   | Event Details: Topic: {topic} Group Id: {group-id}, Offset: {offset}, Key: {key}, Partition: {partition}, Timestamp: {timestamp}, Message: {message}** . In this example we have three Consumers - one for man, one for woman and one common for both. So displayed messages from example above should look like this:
    * consumer3   | Event Details: Topic: helloworld-man,helloworld-woman Group Id: helloworld-human, Offset: 0, Key: helloworld, Partition: 1, Timestamp: 1645763461681, Message: Hello World John
    * consumer1   | Event Details: Topic: helloworld-man, Group Id: helloworld-man-woman, Offset: 0, Key: helloworld, Partition: 1, Timestamp: 1645763461681, Message: Hello World John
    * consumer3   | Event Details: Topic: helloworld-man,helloworld-woman Group Id: helloworld-human, Offset: 0, Key: helloworld, Partition: 1, Timestamp: 1645763490716, Message: Hello World Mary
    * consumer2   | Event Details: Topic: helloworld-woman, Group Id: helloworld-man-woman, Offset: 0, Key: helloworld, Partition: 1, Timestamp: 1645763490716, Message: Hello World Mary
5. Clean up environment
    * Stop containers with `ctrl + C`
    * Remove containers `docker-compose down`