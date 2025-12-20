package org.rap.cognifycommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ConfigurationPropertiesScan
public class CognifyCommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CognifyCommerceApplication.class, args);
    }

}
