DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to work with **Helm Hub**.

##### Details
**Helm** is a package manager for Kubernetes. It means that it helps in management of YAML files - they are stored and distributed as packages. A package in Helm is called **Chart**. Main elements of Helm:
* **Templates**: created from YAML files. These templates can be parsed - tested if there is no errors - and then installed on Kubernetes
* **Values**: variables which can be injected into Templates. In this way Templates can be more generic and reusable. Values can be injected as **Set** or **File**
* **Control Flow**: Templates can be rendered in different way regarding to some conditions
* **Repo**: Charts can be deployed and downloaded from remote repositories
* **Hub**: special type of repository. Available by default. Only confirmed companied can deploy to this repository. But everybody can download Charts from this repository

This example presents how to work with **Hub**. Hub is special repository for Helm - only **verified companies** can push there charts. Developers can only **download from Hub** but they can not push there anything.

Link to:
* **Source Code** of application: `https://github.com/wisniewskikr/chrisblog-it/tree/master/java-springboot/springboot-helloworld-browser-json-actuator-health`
* **Docker Image** of application: `https://hub.docker.com/repository/docker/wisniewskikr/springboot-helloworld-image`

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* Installed **Docker** (tested on version version 20.10.12). Tool details: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`
* Installed **Kubernetes** on Docker (tested on version version 20.10.12). Tool details: `https://docs.google.com/document/d/1jOsK3Lkbkoq-Xx7Ln9o_ozCt6XpcSElOwu1o2AfQnNc/edit?usp=sharing`
* Installed **Helm** (tested on version v3.9.0-rc.1). Tool details: `https://docs.google.com/document/d/1dSk6RSVvJz5_-fDlVYutwYsi93zyEedn7xPkPkGOGV4/edit?usp=sharing`

##### Preconditions - Actions
* **Download** source code and open any **Command Line** tool on **project's folder**. You can do it in following way:
    * Open any Command Line tool (for instance "Windonw PowerShell" on Windows OS) and go to folder where you want to download source code 
    * Clone Github repository with `git clone https://github.com/wisniewskikr/chrisblog-it.git`
    * Go to source code folder with `cd chrisblog-it\java-orchestration-kubernetes-helm\springboot-helm-hub`


USAGE
-----

Usage steps:
1. Search Helm's Hubs with **helm search hub <search_phase>**. For instance: `helm search hub springboot`
1. Add Helm Repo with **helm repo add <repo_name> <hub_URL>**. For instance: `helm repo add helloworld-repo https://laminba2003.github.io/spring-rest-services/`
1. (Optional) Display Helm repo list with `helm repo list`
1. Install Helm Release with **helm install <release_name> <repo_name>/<chart_name>**. For instance: `helm install helloworld-release helloworld-repo/spring-rest --version 0.1.0`
1. Clean up environment:

    * Uninstall Helm Release with **helm uninstall <release_name>**. For instance: `helm uninstall helloworld-release`
    * Remove Helm Repo with **helm repo remove <repo_name>**. For instance: `helm repo remove helloworld-repo`