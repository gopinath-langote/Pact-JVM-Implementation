[![Build Status](https://travis-ci.org/gopinath-langote/Pact-JVM-Implementation.svg)](https://travis-ci.org/gopinath-langote/Pact-JVM-Implementation)


# Pact-JVM-Implementation

Example projects for https://github.com/DiUS/pact-jvm built in spring boot framework.


## Slides from the conference talk `Agile India 2019`
https://www.slideshare.net/GopinathLangote/confidently-releasing-microservices-with-consumer-driven-contracts-1



--------
#Installations 
- Install Java-7 or higher version
- Install IntelliJ IDEA for your operating system. (https://www.jetbrains.com/idea/download/)
- Clone the repository `git clone https://github.com/gopinath-langote/Pact-JVM-Implementation.git`
- Open the project(root directory `Pact-JVM-Implementation`) in `IntelliJ IDEA`. This will take a while to download dependencies.
- Go to the project directory `cd Pact-JVM-Implementation` 


##### Run following commands on the terminal or command prompt.

# Build the application
For Linux/Mac : `./gradlew clean build`

For Windows : `gradlew.bat clean build`

`This can take some time to download dependencies`

# Run the User Service (Producer service)
For Linux/Mac : `./gradlew :user-service:bootRun` 

For Windows : `gradlew.bat :user-service:bootRun` 

- Check service is running or not at [http://localhost:8052/api/user/1](http://localhost:8052/api/user/1)

# Run the Account Service (Consumer service)
For Linux/Mac : `./gradlew :account-service:bootRun` 

For Windows : `gradlew.bat :account-service:bootRun` 

- Check service is running or not at [http://localhost:8051/api/account/1/statement](http://localhost:8051/api/account/1/statement)

# Run the Consumer Service Contract Test(Account service)
run the test `com.vodqa.pact.accountervice.UserContractTest`

# Run the Provider Service Contract Verification(User service)
(Make sure provider service is running locally before verifying pact)

For Linux/Mac : `./gradlew :user-service:pactVerify` 

For Windows : `gradlew.bat :user-service:pactVerify` 
