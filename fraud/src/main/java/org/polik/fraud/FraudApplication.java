package org.polik.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Created by Polik on 5/31/2022
 */
@SpringBootApplication
@PropertySources(
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
)
public class FraudApplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class, args);
    }
}
