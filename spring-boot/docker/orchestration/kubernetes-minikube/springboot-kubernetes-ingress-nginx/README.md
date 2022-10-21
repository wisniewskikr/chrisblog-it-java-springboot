DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use **Ingress** with **Ingress Controller** type **nginx** for simple "Hello World" **Java Spring Boot** application using **Kubernetes** type **Minikube** tool.


##### Details

**Minikube** is type of Kubernetes for development or tests on local machine. It creates only one Kubernetes Cluster. It doesn't require external Docker. It has it's own instance.

**Ingress** enables connecting domain with Kubernetes service. To connect them you need Kubernetes "plugin" - Ingress Controller - and configuration - Ingress. There are differente types of Ingress Controllers - nginx, traefik etc. This example describes how to use Ingress Controller type "nginx". 

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
* Installed **Minikube** (tested on version version 1.26.0). Tool details: `https://docs.google.com/document/d/1GfgN7tJNTIJCaSzexJdR_Lm_S9pF2YykcpgSQzAZWZo/edit?usp=sharing`

##### Preconditions - Actions
* **Start Minikukbe** tool with `minikube start`. Details you can find here: `https://docs.google.com/document/d/1GfgN7tJNTIJCaSzexJdR_Lm_S9pF2YykcpgSQzAZWZo/edit?usp=sharing`
* **Enable Minikube addon "ingress"** with `minikube addons enable ingress`. Details you can find here: `https://docs.google.com/document/d/1GfgN7tJNTIJCaSzexJdR_Lm_S9pF2YykcpgSQzAZWZo/edit?usp=sharing`
* **Download** source code and open any **Command Line** tool on **project's folder**. You can do it in following way:
    * Open any Command Line tool (for instance "Windonw PowerShell" on Windows OS) and go to folder where you want to download source code 
    * Clone Github repository with `git clone https://github.com/wisniewskikr/chrisblog-it.git`
    * Go to source code folder with `cd chrisblog-it\java-orchestration-kubernetes-minikube\springboot-kubernetes-ingress-nginx`


USAGE
-----

Usage steps:

1. Deploy application to Kubernetes with `kubectl apply -f deployment.yml`
1. (Optional) Check deployment

    * Display list of deployments with `kubectl get deployments`
    * Display describe for specific deployment with `kubectl describe deployment helloworld-deployment`
1. (Optional) Check service

    * Display list of services with `kubectl get service`
    * Display describe for specific service with `kubectl describe service helloworld-service`
1. (Optional) Check pod`s logs

    * Display list of pods with `kubectl get pods`
    * Display describe for specific pod with `kubectl describe pod <pod_id>`
    * Display log for specific pod with `kubectl logs <pod_id>`
1. (Optional) Get service url with `minikube service helloworld-service --url`
1. (Optional) Visit above url
1. Install Ingress with `kubectl apply -f ingress.yml`
1. Check Ingress (field **Address** can be filled after couple of minutes)
     * Display list of Ingresses with `kubectl get ingress`
     * Display describe for specific Ingress with **kubectl describe ingress <ingress_name>**. For instance with `kubectl describe ingress helloworld-ingress`
1. Map domain with Address locally. On Windows OS please go to **Widnows -> System32 -> drivers -> etc -> hosts** and add new mapping there **{ingress_address} helloworld.example**. For instance `192.168.1.50 helloworld.example`
1. Visit `helloworld.example`
1. Clean up environment:

    * Delete Kubernetes ingress with `kubectl delete ingress helloworld-ingress`
    * Delete Kubernetes service with `kubectl delete service helloworld-service`
    * Delete Kubernetes deployment with `kubectl delete deployment helloworld-deployment`