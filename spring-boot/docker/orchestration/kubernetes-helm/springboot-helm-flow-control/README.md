DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to work with **Helm Control Flow** for simple "Hello World" **Java** application with **Spring Boot** framework using **Kubernetes** and **Helm** tools. 


##### Details
**Helm** is a package manager for Kubernetes. It means that it helps in management of YAML files - they are stored and distributed as packages. A package in Helm is called **Chart**. Main elements of Helm:
* **Templates**: created from YAML files. These templates can be parsed - tested if there is no errors - and then installed on Kubernetes
* **Values**: variables which can be injected into Templates. In this way Templates can be more generic and reusable. Values can be injected as **Set** or **File**
* **Control Flow**: Templates can be rendered in different way regarding to some conditions
* **Repo**: Charts can be deployed and downloaded from remote repositories
* **Hub**: special type of repository. Available by default. Only confirmed companied can deploy to this repository. But everybody can download Charts from this repository

This example presents how to work with **Control Flow**. You can use if-else statements, loops etc. to render Templates in different ways depending on conditions. In this example message "Hello World" will be displayed in one of two languages - **EN or PL** - depending on set **lang**.

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
    * Go to source code folder with `cd chrisblog-it\java-orchestration-kubernetes-helm\springboot-helm-control-flow`


USAGE
-----

Usage steps:
1. Create Helm's Chart with **helm create {chart_name}**. For instance: `helm create springboot-helloworld-chart`
1. Remove from Chart default folder Templates (confirmation with "Y" is required) with `rmdir springboot-helloworld-chart\templates`
1. Copy in advance prepared Templates from folder **source** with `xcopy source springboot-helloworld-chart /E /H /C /I /Y`
1. (Optional) Parse Template for language **EN** with **helm template -f {file_with_values} --set lang=en {installation_name} {chart_name}**. For instance with `helm template -f springboot-helloworld-chart/values.yaml --set lang=en springboot-helloworld-chart-instance springboot-helloworld-chart`
1. Install Template for language **EN** with **helm install -f {file_with_values} --set lang=en {installation_name} {chart_name}**. For instance with `helm install -f springboot-helloworld-chart/values.yaml --set lang=en springboot-helloworld-chart-instance springboot-helloworld-chart`
1. (Optional) Check Template installation with `helm list`
1. Visit (it can takes few minutes to set up) `http://localhost:31000`
1. Uninstall Template for language **EN** with **helm uninstall {installation_name}**. For instance with `helm uninstall springboot-helloworld-chart-instance`
1. (Optional) Parse Template for language **PL** with **helm template -f {file_with_values} --set lang=pl {installation_name} {chart_name}**. For instance with `helm template -f springboot-helloworld-chart/values.yaml --set lang=en springboot-helloworld-chart-instance springboot-helloworld-chart`
1. Install Template for language **PL** with **helm install -f {file_with_values} --set lang=pl {installation_name} {chart_name}**. For instance with `helm install -f springboot-helloworld-chart/values.yaml --set lang=pl springboot-helloworld-chart-instance springboot-helloworld-chart`
1. (Optional) Check Template installation with `helm list`
1. Visit (it can takes few minutes to set up) `http://localhost:31000`
1. Clean up environment:

    * Uninstall Template with **helm uninstall {installation_name}**. For instance with `helm uninstall springboot-helloworld-chart-instance`
    * Remove Chart folder (confirmation with "Y" is required) with `rmdir springboot-helloworld-chart`