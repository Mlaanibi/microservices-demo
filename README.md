# Microservices Architecture 
This is an example of Microservices Architecture using Spring Boot, Spring Cloud, and Netflix OSS frameworks such as Hystrix, Eureka.

# Architecture Components
The demo consists of 5 microservices with configuration server and discovery server. 

* config server - Centralized configuration server
* discovery server - Service discovery server
* account core service - Core service for an account
* payments core service - Core service for payment detail for an account
* account composite service - Composite Service that aggregates the results of accounts and payment details for each account
* account api service - API service for account
* transactions api service - API service for transaction


