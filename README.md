## Microservices Architecture Demo Application
This is an example of Microservices Architecture using Spring Boot, Spring Cloud, and Netflix OSS frameworks such as Hystrix, Eureka. 

## Table of Contents
* [Application Architecture](#application-architecture)
* [Spring Boot Overview] (#spring-boot-overview)
* [Spring Cloud Overview] (#spring-cloud-overview)
* [Spring Cloud Config Overview] (#spring-config-overview)
* [Spring Cloud Netflix Overview] (#spring-cloud-netflix-overview)

## <a name="application-architecture"></a>Application Architecture
Architecture consists of 6 business services, a centralized config server and service discovery server.Each component is built separately using their own build file. We use gradle as build system.

![Microservices Architecture](https://cloud.githubusercontent.com/assets/5256077/12605129/d2bf8090-c4e7-11e5-812c-c432d056134a.jpg)

### Architecture Components
* Core services responsible for handling information regarding accounts, payments and transactions. Account Core Service manages accounts, Payments Core Service manages payments for a given account and Transactions Core Service manages transactions for a given account.
    * [account core service] (#core-services) - Account Core Service
    * [payments core service] (#core-services) - Payments Core Service for a given account
    * [transaction core service] (#core-services) - Transaction Core Service for a given account

* Composite service, accounts-composite-service, that aggregates information from the two core services and composes a view of account information together with payment information for an account.

    * [account composite service] (#accounts-composite-service) - Composite Service that aggregates the results of accounts and payment details for a given account

* API services, Accounts API Service retrieves account and payment information by invoking Accounts Composite Service and Transactions API Service retrieves transactions from Transactions Core Service.  
    * [account api service] (#api-services) - API service for accounts
    * [transactions api service] (#api-services) - API service for transactions

* [Config server] (#sample-config-server) - Uses [Spring Cloud Config] (http://cloud.spring.io/spring-cloud-config/) for centralized management of external properties for applications across all environments. Spring Cloud is a new project in the spring.io family with a set of components that can be used to implement Microservices Architecture. To a large extent Spring Cloud 1.0 is based on components from Netflix OSS. Spring Cloud integrates the Netflix components in the Spring environment in a way using auto configuration and convention over configuration similar to how Spring Boot works.

* [Service discovery server] (#discovery-server) - Uses [Netflix Eureka] (https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance) as service discovery server. Netflix Eureka allows microservices to register themselves at runtime as they appear in the system landscape.

## <a name="spring-boot-overview"></a>Spring Boot Overview
Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that can be "just run". 
Most Spring Boot applications need very little Spring configuration. Spring Boot embeds Tomcat, Jetty or Undertow directly and there is no need to deploy WAR files. You can use Spring Boot to create Java applications that can be started using java -jar or more traditional war deployments. It provides production-ready features such as metrics, health checks and externalized configuration.

## <a name="spring-cloud-overview"></a>Spring Cloud Overview
The goal of Spring Cloud is to provide the Spring developers with an easily consumable set of tools to build distributed systems with common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus, one-time tokens, global locks, leadership election, distributed sessions, cluster state). It primarily does this by wrapping other implementation stacks, starting with the Netflix OSS stack. These stacks are then consumed via the familiar tools of annotation-based configuration, Java configuration, and template-based programming.

## <a name="spring-config-overview"></a>Spring Cloud Config Overview
## <a name="spring-cloud-netflix-overview"></a>Spring Cloud Netflix Overview
