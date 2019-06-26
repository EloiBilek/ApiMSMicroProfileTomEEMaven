#Concept

## Which is:
Microprofile is an initiative of some Java EE vendors(Red Hat, Payara, Tomitribe, IBM, Eclipse Foundation) e Java User Groups (SouJava and London Java Community) whose main goal is to bring micro-service innovations around or around the world Java EE.

"Eclipse: Eclipse MicroProfile - Optimizing Enterprise Java for a Microservices Architecture"

https://microprofile.io/

## Server used for this project:
Apache TomEE is the Java Enterprise Edition of Apache Tomcat that combines several Java enterprise projects, including Apache OpenEJB, Apache OpenWebBeans, Apache OpenJPA, Apache MyFaces and others, with high performance for Microprofile-based projects.

https://tomee.apache.org/

## How to use:
https://www.devmedia.com.br/introducao-ao-apache-tomee/29933

### Debug mode:
https://www.tomitribe.com/blog/its-easy-remote-debugging-with-eclipse-and-tomee/
 
## Data Base:
H2 is a relational database management system written in Java. It can be embedded in Java applications or run in client-server mode. 
The software is available as open source software by the Mozilla Public License 2.0 or the original public Eclipse license.

https://www.h2database.com/html/main.html
 
## How to use:
http://zetcode.com/java/h2database/

## Front-end:
Pure HTML, with javascript and jquery interactions (Ajax - Rest request/response).
 
#TUTORIAL
Within the project's target folder, there are three files to be able to execute the project in three different ways:

## Start system with deploy on application server:
To use the file ApiMSMicroProfileTomEEMaven.war, to deploy in a conventional way, for its operation it will be necessary to configure the H2 database on the chosen server.
 
## Start system with TomEE.
The ApiMSMicroProfileTomEEMaven.zip file contains the TomEE server code with the project (.war) in the deploy (webapp) folder, however this form requires some configuration (permission to execute the .sh ... files).

## Start standalone system (USE THIS! IT HAS BEEN TESTED ON UBUNTU16 AND WIN10):
The file ApiMSMicroProfileTomEEMaven-exec.jar, is an executable jar file, it contains the project, with the server and the database embedded. 
To start it, just run the command: java -jar CrudTesteFiscaltech-exec.jar
It starts the server and its libraries, the project already in the deploy folder and the H2 bank with its settings.

URL for access:
http://localhost:8082/login.html

Info to access the database sql console H2:
 - Generic H2 (Embedded)
 - org.h2.Driver
 - jdbc:h2:~/my_h2_db
 - sa
 - sa
 
After accessing the console, execute the scripts from the 01.sql script file (resources folder), where the tables will be generated and the vehicle's colors will be populated.

#OBS 1: I did not validate the fields ... it is recommended to insert all values of the inputs.

#End.


