## Overview
Hystrix dashboard is used to provide a graphical overview of circuit breakers. 

Run this app as a normal Spring Boot app and then go to the home page in a browser (http://localhost:7979/hystrix). If you run from this project it will be on port 7979 (per the application.yml). On the home page is a form where you can enter the URL for an event stream to monitor, for example:

* the accounts service running locally: http://localhost:8082/hystrix.stream and 
* the transactions service running locally: http://localhost:8083/hystrix.stream. 

These services use @EnableHystrix to expose the stream.

Sample screenshots from Hystrix dashboard:
