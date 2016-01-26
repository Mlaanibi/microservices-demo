package rest.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class AccountCoreServiceApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(AccountCoreServiceApplication.class, args);
    }
	
}
