DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to work with **Helm Repo** for simple "Hello World" **Java** application with **Spring Boot** framework using **Kubernetes** and **Helm** tools. 


##### Details
**Helm** is a package manager for Kubernetes. It means that it helps in management of YAML files - they are stored and distributed as packages. A package in Helm is called **Chart**. Main elements of Helm:
* **Templates**: created from YAML files. These templates can be parsed - tested if there is no errors - and then installed on Kubernetes
* **Values**: variables which can be injected into Templates. In this way Templates can be more generic and reusable. Values can be injected as **Set** or **File**
* **Control Flow**: Templates can be rendered in different way regarding to some conditions
* **Repo**: Charts can be deployed and downloaded from remote repositories
* **Hub**: special type of repository. Available by default. Only confirmed companied can deploy to this repository. But everybody can download Charts from this repository

This example presents how to work with **Repo**. Repo means that you can create Chart and push it to some remote repository. Then some other developer can pull this Chart from remote repository and use it locally. In this example remote repository is **GitHub Pages**. Remote repository for Chart is just **web server** (like GitHub Pages) which should contain three elements:
* file ** *.tgz** with Chart content. There is Helm command which creates such package
* file **index.yaml** with description of Chart. There is Helm command which creates such file
* file **Chart.yaml** with details of Chart

Link to:
* **Source Code** of application: `https://github.com/wisniewskikr/chrisblog-it/tree/master/java-springboot/springboot-helloworld-browser-json-actuator-health`
* **Docker Image** of application: `https://hub.docker.com/repository/docker/wisniewskikr/springboot-helloworld-image`

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Github Pages** it's part of GIT tool: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`


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
    * Go to source code folder with `cd chrisblog-it\java-orchestration-kubernetes-helm\springboot-helm-repo`
* Create **GitHub** repository named **springboot-helloworld-chart** with enabled **GitHub Pages** on branch **main**. How to do it you can find here: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`


USAGE
-----

Usage steps:
1. Create Helm's Chart with **helm create {chart_name}**. For instance: `helm create springboot-helloworld-chart`
1. Remove from Chart default folder Templates (confirmation with "Y" is required) with `rmdir springboot-helloworld-chart\templates`
1. Copy in advance prepared Templates from folder **source** with `xcopy source springboot-helloworld-chart /E /H /C /I /Y`
1. Go to Chart folder with `cd springboot-helloworld-chart`
1. Prepare Chart package with `helm package .`
1. Prepare Chart index with `helm repo index .`
1. Create temporary directory on disc C with `mkdir C:\tmp`
1. Copy Chart package to temporary directory with `copy springboot-helloworld-chart-0.1.0.tgz C:\tmp`
1. Copy Chart main file to temporary directory with `copy Chart.yaml C:\tmp`
1. Copy Chart index to temporary directory with `copy index.yaml C:\tmp`
1. Return Chart folder with `cd ..`
1. Remove Chart folder (confirmation with "Y" is required) with `rmdir springboot-helloworld-chart`
1. Go to temporary directory with `cd C:\tmp`
1. Init Git in temporary directory with `git init`
1. Add origin with **git remote add origin <remote_repository_URL>**. It should look like this `git remote add origin git@github.com:{your_github_repo}/springboot-helloworld-chart.git`. (For instance: "git remote add origin git@github.com:wisniewskikr/springboot-helloworld-chart.git")
1. Pull origin with `git pull origin`
1. Change branch to **main** with `git checkout main`
1. Add files to local repository with `git add .`
1. Commit changes to local repository with `git commit -m "Init repo"`
1. Push changes to origin repository with `git push origin main`
1. Add Helm repo with **helm repo add helloworld-repo <github_pages_URL>**. It should look like this: `helm repo add helloworld-repo https://{your_github_id}.github.io/springboot-helloworld-chart/`. (For instance: "helm repo add helloworld-repo https://wisniewskikr.github.io/springboot-helloworld-chart/")
1. (Optional) Display Helm repo list with `helm repo list`
1. (Optional) Search Helm repo with `helm search repo`
1. (Optional) Parse Template with **helm template {installation_name} {repo_name}/{chart_name}**. For instance with `helm template springboot-helloworld-chart-instance helloworld-repo/springboot-helloworld-chart`
1. Install Template with **helm install {installation_name} {repo_name}/{chart_name}**. For instance with `helm install springboot-helloworld-chart-instance helloworld-repo/springboot-helloworld-chart`
1. (Optional) Check Template installation with `helm list`
1. Visit (it can takes few minutes to set up) `http://localhost:31000`
1. Clean up environment:

    * Uninstall Template with **helm uninstall {installation_name}**. For instance with `helm uninstall springboot-helloworld-chart-instance`
    * Remove Helm repo with `helm repo remove helloworld-repo`
    * Go to disc C with `cd C:\`
    * Remove temporary folder (confirmation with "Y" is required) with `rmdir C:\tmp`
    * Remove files **springboot-helloworld-chart-0.1.0.tgz**, **Chart.yaml** and **index.yaml** from Github project manually