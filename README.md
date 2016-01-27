## Microservices Architecture 
This is an example of Microservices Architecture using Spring Boot, Spring Cloud, and Netflix OSS frameworks such as Hystrix, Eureka. Architecture consists of 6 business services, a centralized config server and service discovery server.Each component is built separately using their own build file. We use gradle as build system.

![Microservices Architecture](https://cloud.githubusercontent.com/assets/5256077/12605129/d2bf8090-c4e7-11e5-812c-c432d056134a.jpg)

## Architecture Components
* Three core services responsible for handling information regarding accounts, payments and transactions. 
    * [account core service] (#accounts-core-service) - Account Core Service
    * [payments core service] (#payments-core-service) - Payments Core Service for a given account
    * [transaction core service] (#transactions-core-service) - Transaction Core Service for a given account

* One composite service, accounts-composite-service, that can aggregate information from the two core services and compose a view of account information together with payment information for an account. 
    * [account composite service] (#accounts-composite-service) - Composite Service that aggregates the results of accounts and payment details for a given account

* Two API services that can be exposed to consumer
    * [account api service] (#accounts-api-service) - API service for account
    * [transactions api service] (#transactions-api-service) - API service for transaction

The Architecture is supported by configuration server and discovery server. 
* [config server] (#sample-config-server) - Centralized configuration server
* [discovery server] (#discovery-server) - Service discovery server

#### <a name="sample-config-server"></a> Config Server
Uses [Spring Cloud Config] (http://cloud.spring.io/spring-cloud-config/) for centralized management of external properties for applications across all environments. Spring Cloud is a new project in the spring.io family with a set of components that can be used to implement Microservices Architecture. To a large extent Spring Cloud 1.0 is based on components from Netflix OSS. Spring Cloud integrates the Netflix components in the Spring environment in a way using auto configuration and convention over configuration similar to how Spring Boot works.

#### <a name="discovery-server"></a> Service Discovery Server
Uses [Netflix Eureka] (https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance) as service discovery server. Netflix Eureka allows microservices to register themselves at runtime as they appear in the system landscape.

#### <a name="accounts-core-service"></a> Account Core Service

#### <a name="payments-core-service"></a> Payments Core Service

#### <a name="transactions-core-service"></a> Transactions Core Service

#### <a name="accounts-composite-service"></a> Accounts Composite Service

#### <a name="accounts-api-service"></a> Accounts API Service

#### <a name="transactions-api-service"></a> Transactions API Service




