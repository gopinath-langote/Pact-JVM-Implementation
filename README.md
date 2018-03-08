# Pact-JVM-Implementation

Example projects for https://github.com/DiUS/pact-jvm built in spring boot framework.
--------
#Installations 
- Install java-7 or higher version
- Install IntelliJ IDEA for your operating system. (https://www.jetbrains.com/idea/download/)
- Clone the repository `git clone https://github.com/gopinath-langote/Pact-JVM-Implementation.git`
- Open the project in `IntelliJ IDEA`
- Go to project directory and run following commands.

# Build the appliaction
For Linux/Mac : `./gradlew clean build --no-daemon`

For Windows : `gradlew.bat clean build --no-daemon`


# Run the Customer-Service (Producer service)
For Linux/Mac : `./gradlew :customer-service:bootRun` 

For Windows : `gradlew.bat :customer-service:bootRun` 

- Check service is running or not at `localhost:8052/customer`

# Run the Payment-Service (Consumer service)
For Linux/Mac : `./gradlew :payment-service:bootRun` 

For Windows : `gradlew.bat :payment-service:bootRun` 

- Check service is running or not at `localhost:8052/payment`
