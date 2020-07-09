# Referral's back-end components

- RESTFull API component.
- Service component.

## How to start back-end application.
The project is Maven project, so you can use any IDE for development.

#### 1. Install tools:
 - Install Java JDK (https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).
 - Install IDE (https://www.jetbrains.com/idea/download/#section=mac).
 - Install Maven if the IDE does not have Maven (https://maven.apache.org/download.cgi).  
 - Install GIT client (https://desktop.github.com/).
 - Install postman / HTTP request sender (https://www.postman.com/).
 - Clone repository on your local and create your own branch. (https://github.com/MITPU/referral).
 
 
#### 2. Open project
 - Open your IDE.
 - File -> New -> Project from existing sources.
 - Select Maven -> Finish.
 
#### 3. Start Application
 - Set development configuration.
 (./src/main/resources/application-dev.properties)
 - Open main java class which is 'CoreApplication.java'
 - There are several ways to run application: 
   1. Right click on CoreApplication.java then click 'Run application'.
   2. Menu bar -> Run -> Run -> select 'CoreApplication.java'.
   3. Click on the green play button, left side of the class.
 - For default, application will listen 8080 port on your localhost.
 
#### 4. Test application
- Open postman application.
- Download 'referral' collection (https://www.getpostman.com/collections/e09ced9592db6946d293)
- Send request to your local application.
