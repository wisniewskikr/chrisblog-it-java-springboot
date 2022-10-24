JUNIT SELENIUM GRID
===================


DESCRIPTION
-----------

This project shows how to do selenium grid tests. 
Selenium grid means that selenium is run on another standalone server in Docker.


PREREQUISITES
=============

Reqirements before tests:
- Run selenium grid in docker using following command: docker run -d -p 4444:4444 -p 5900:5900 --shm-size="2g" selenium/standalone-chrome:4.1.0-prerelease-20211105
