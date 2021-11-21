# Cucumber Framework with Parllel Testing in Docker Containers

## Tech stack Used
Java, Cucumber, Selenium Webdriver, TestNG, Extent, Docker

# Prerequisites 
- Java 8 and above 
- Any IDE 
- Install Maven and set the Environment Variable
- For Cucumber's actual flavour, install a plugin for cucumber in IDE and convert project into cucumber project
- Download and Extract this project to your local or use git clone https://github.com/aravind12c/flinktestassesment.git
- Import as a Maven project in any IDE

### To run in Docker
- Install Docker or Docker Desktop (Refer url https://docs.docker.com/engine/install/)
- Open Docker Desktop or Start the Docker Engine
- Open Command and give cd "Project Folder"
- Then enter command docker-compose up -d
    
## Project Setup 
- Driver setup and capabilities : \src\main\java\com.flink.driverInit\
- Page Obejcts 					: \src\main\java\com.flink.pageObjects\
- Failure Retry					: \src\main\java\com.flink.retryCase\
- Web Utilities 				: \src\main\java\com.flink.webUtilities\
- Web Configs 					: \src\test\resources\driver\WebConfig
- Test Runner  					: \src\test\java\com.flink.testfactory\
- Step Definitions 				: \src\test\java\com.flink.stepDefinitions\
- Feature files 				: \src\test\resources\Features\
- Extent Configs				: \src\test\resources\extent-config\
- Extent Properties				: \src\test\resources\

## Pre-Steps
- If you want to update URL and Payment details, please open config.properties from Web Config and update it.
- In you want to run the project in docker, in config properties change the runmode to remote and if you want to run in local change the runmode to local(By default its in local)

## Steps to run
- Open tesNG.xml file, from "TestNGXML" folder
- Now run as TestNG Suite
or
- go to the project folder and use mvn clean install
or
- run the pom.xml as maven build

## Approach 
Below are the points considered while creating the framework
- Project - Maven Project
- Design pattern - Page object model
- Framework - Cucumber(For Test approach), Selenium Driver(For UI Automation), TestNG(For Parallel Execution and Retry Failed Cases), Extent(For Report)
- Language - Java

## Note 
I have added retry scenarios on failures. If by chance any case fails while execution, then it will automatically triggers the failed cases. If any case got failed, it will be marked as Skipped in Console as it got retried and passed on second execution.
