[![Build Status](https://travis-ci.org/gopinath-langote/Pact-JVM-Implementation.svg)](https://travis-ci.org/gopinath-langote/Pact-JVM-Implementation)


# Pact-JVM-Implementation

Example projects for https://github.com/DiUS/pact-jvm built in spring boot framework.

--------
### Prerequisite 
- Java-8

### Clone Project
- Clone repository `git clone https://github.com/gopinath-langote/Pact-JVM-Implementation.git`
- Go to the project directory `cd Pact-JVM-Implementation` 

### Run following commands on the terminal or command prompt.

# Build the application
For Linux/Mac : `./gradlew clean build`

For Windows : `gradlew.bat clean build`

`This can take some time to download dependencies`

# Run the User Service (Producer service)
For Linux/Mac : `./gradlew :user-service:bootRun` 

For Windows : `gradlew.bat :user-service:bootRun` 

- Check if service is running at [http://localhost:8052/api/user/static](http://localhost:8052/api/user/static)

# Run the Account Service (Consumer service)
For Linux/Mac : `./gradlew :account-service:bootRun` 

For Windows : `gradlew.bat :account-service:bootRun` 

- Check if service is running at [http://localhost:8051/api/account/static/statement](http://localhost:8051/api/account/static/statement)

