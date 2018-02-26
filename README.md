# Pact-JVM-Implementation

Example projects for https://github.com/DiUS/pact-jvm built in spring boot framework.


# Build the appliaction
`./gradlew clean build`


# Run the Customer-Service (Producer service)
1. `./gradlew :customer-service:bootRun` 
2. See `localhost:8052/customer`

# Run the Payment-Service (Consumer service)
1. `./gradlew :payment-service:bootRun` 
2. See `localhost:8051/payment`
