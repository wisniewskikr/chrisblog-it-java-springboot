SPRING BOOT MVC THYMELEAF AND YOUTUBE
=====================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

This is simple Spring Boot MVC project which displays Greeting page.
This page contains:
* text "Hello World"
* youtube movie "Hello World"

Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf


IMPLEMENTATION
-----------

Prerequisites:
* Download project "mvc-thymeleaf";
* Find youtube movie which you want to display.

Implementation details:
* On a computer, go to the YouTube video you want to embed;
* Under the video, click SHARE;
* Click Embed;
* From the box that appears, copy the HTML code;
* Paste the code into page "greeting.html";
* (Optional) On page "greeting.html" wrap embedded "iframe" element with "div" with class "embed-responsive". Embedded "iframe" should have class "embed-responsive-item".
  

LAUNCH
------

To launch project please run following class: 
* Application.java

You can also launch project using Maven command:
* mvn spring-boot:run -Dspring.thymeleaf.cache=false


USAGE
-----

Link to main UI:
* http://[server]/app/greeting