[![Build Status](https://travis-ci.org/gopinath-langote/Pact-JVM-Implementation.svg)](https://travis-ci.org/gopinath-langote/Pact-JVM-Implementation)


# Pact-JVM-Implementation

Example projects for https://github.com/DiUS/pact-jvm built in spring boot framework.
--------
#Installations 
- Install Java-7 or higher version
- Install IntelliJ IDEA for your operating system. (https://www.jetbrains.com/idea/download/)
- Clone the repository `git clone https://github.com/gopinath-langote/Pact-JVM-Implementation.git`
- Open the project(root directory `Pact-JVM-Implementation`) in `IntelliJ IDEA`. This will take a while to download dependencies.
- Go to the project directory `cd Pact-JVM-Implementation` 


##### Run following commands on the terminal or command prompt.

# Build the application
For Linux/Mac : `./gradlew clean build --no-daemon`

For Windows : `gradlew.bat clean build --no-daemon`

`This can take some time to download dependencies`

# Run the User Service (Producer service)
For Linux/Mac : `./gradlew :user-service:bootRun --no-daemon` 

For Windows : `gradlew.bat :user-service:bootRun --no-daemon` 

- Check service is running or not at [http://localhost:8052/user](http://localhost:8052/user)

# Run the Account Service (Consumer service)
For Linux/Mac : `./gradlew :Account-service:bootRun --no-daemon` 

For Windows : `gradlew.bat :Account-service:bootRun --no-daemon` 

- Check service is running or not at [http://localhost:8051/Account](http://localhost:8051/Account)
