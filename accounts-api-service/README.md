## Overview
This is an api service for an account. It exposes REST endpoints that are used to provide account functionality.

## Pre-requisites
Projects that need to be started before

* sample config server - For pulling the configuration information
* discovery-server - For starting the Eureka server to register all the services (api, core and composite)

## Running the application
Build the application by running the gradle clean build gradle command at the "accounts-api-service" project root folder on the terminal.
If you want to run the application as jar file, then run java -jar build/libs/accounts-api-service-1.0.0.jar command at the terminal.

##External Configuration

The project derives it's configuration from the config server service. We have defined the spring.cloud.config.uri in the bootstrap.yml file and that tells the application where to pick up the external confiurations. In our case, the URL points to the running config server server. You also need to have the spring-cloud-config-client dependency in the classpath so that the application can comsume the config server.

A Spring Cloud application operates by creating a "bootstrap" context, which is a parent context for the main application. This bootstrap context loads properties from external sources (the config-server) and decrypts the properties if required.

The bootstrap context for external configuration is located by convention at bootstrap.yml whereas the internal configuration is located by convention at application.yml. Note that you can also have .properties file instead of .yml files.
