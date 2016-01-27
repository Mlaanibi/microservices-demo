## Microservices Architecture Demo Application
This is an example of Microservices Architecture using Spring Boot, Spring Cloud, and Netflix OSS frameworks such as Hystrix, Eureka. 

# Table of Contents
* [Application Architecture](#application-architecture)
* [Spring Boot Overview] (#spring-boot-overview)
* [Spring Cloud Overview] (#spring-cloud-overview)
* [Spring Cloud Config Overview] (#spring-config-overview)
* [Spring Cloud Netflix Overview] (#spring-cloud-netflix-overview)

## <a name="application-architecture"></a>Application Architecture
Architecture consists of 6 business services, a centralized config server and service discovery server.Each component is built separately using their own build file. We use gradle as build system.

![Microservices Architecture](https://cloud.githubusercontent.com/assets/5256077/12605129/d2bf8090-c4e7-11e5-812c-c432d056134a.jpg)

### Architecture Components
* Three core services responsible for handling information regarding accounts, payments and transactions. Account Core Service manages accounts, Payments Core Service manages payments for a given account and Transactions Core Service manages transactions for a given account.
    * [account core service] (#core-services) - Account Core Service
    * [payments core service] (#core-services) - Payments Core Service for a given account
    * [transaction core service] (#core-services) - Transaction Core Service for a given account

* One composite service, accounts-composite-service, that aggregates information from the two core services and composes a view of account information together with payment information for an account.

    * [account composite service] (#accounts-composite-service) - Composite Service that aggregates the results of accounts and payment details for a given account

* Two API services, Accounts API Service retrieves account and payment information by invoking Accounts Composite Service and Transactions API Service retrieves transactions from Transactions Core Service.  
    * [account api service] (#api-services) - API service for accounts
    * [transactions api service] (#api-services) - API service for transactions

The Architecture is supported by configuration server and discovery server. 
* [config server] (#sample-config-server) - Centralized configuration server
Uses [Spring Cloud Config] (http://cloud.spring.io/spring-cloud-config/) for centralized management of external properties for applications across all environments. Spring Cloud is a new project in the spring.io family with a set of components that can be used to implement Microservices Architecture. To a large extent Spring Cloud 1.0 is based on components from Netflix OSS. Spring Cloud integrates the Netflix components in the Spring environment in a way using auto configuration and convention over configuration similar to how Spring Boot works.

* [discovery server] (#discovery-server) - Service discovery server
Uses [Netflix Eureka] (https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance) as service discovery server. Netflix Eureka allows microservices to register themselves at runtime as they appear in the system landscape.

## <a name="spring-boot-overview"></a>Spring Boot Overview
## <a name="spring-cloud-overview"></a>Spring Cloud Overview
## <a name="spring-config-overview"></a>Spring Cloud Config Overview
## <a name="spring-cloud-netflix-overview"></a>Spring Cloud Netflix Overview
