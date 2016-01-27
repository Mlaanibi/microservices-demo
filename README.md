## Microservices Architecture 
This is an example of Microservices Architecture using Spring Boot, Spring Cloud, and Netflix OSS frameworks such as Hystrix, Eureka. Architecture consists of 6 business services, a centralized config server and service discovery server.Each component is built separately using their own build file. We use gradle as build system.

![Microservices Architecture](https://cloud.githubusercontent.com/assets/5256077/12605129/d2bf8090-c4e7-11e5-812c-c432d056134a.jpg)

## Architecture Components
* Three core services responsible for handling information regarding accounts, payments and transactions. 
    * [account core service] (#core-services) - Account Core Service
    * [payments core service] (#core-services) - Payments Core Service for a given account
    * [transaction core service] (#core-services) - Transaction Core Service for a given account

* One composite service, accounts-composite-service, that can aggregate information from the two core services and compose a view of account information together with payment information for an account. 
    * [account composite service] (#accounts-composite-service) - Composite Service that aggregates the results of accounts and payment details for a given account

* Two API services that can be exposed to consumer
    * [account api service] (#api-services) - API service for accounts
    * [transactions api service] (#api-services) - API service for transactions

The Architecture is supported by configuration server and discovery server. 
* [config server] (#sample-config-server) - Centralized configuration server
* [discovery server] (#discovery-server) - Service discovery server

#### <a name="sample-config-server"></a> Config Server
Uses [Spring Cloud Config] (http://cloud.spring.io/spring-cloud-config/) for centralized management of external properties for applications across all environments. Spring Cloud is a new project in the spring.io family with a set of components that can be used to implement Microservices Architecture. To a large extent Spring Cloud 1.0 is based on components from Netflix OSS. Spring Cloud integrates the Netflix components in the Spring environment in a way using auto configuration and convention over configuration similar to how Spring Boot works.

#### <a name="discovery-server"></a> Service Discovery Server
Uses [Netflix Eureka] (https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance) as service discovery server. Netflix Eureka allows microservices to register themselves at runtime as they appear in the system landscape.

#### <a name="core-services"></a> Core Services
Three core services namely Account Core Service manages accounts, Payments Core Service manages payments for a given account and Transactions Core Service manages transactions for a given account

#### <a name="accounts-composite-service"></a> Accounts Composite Servicee
Accounts Composite Service retrieves accounts and payment details, aggregates and composes the result.

#### <a name="api-services"></a> API Services
Accounts API Service retrieves account and payment information by invoking Accounts Composite Service and Transactions API Service retrieves transactions from Transactions Core Service.ns API Service




