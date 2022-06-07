package org.polik.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Created by Polik on 6/3/2022
 */
@SpringBootApplication(
        scanBasePackages = {
                "org.polik.notification",
                "org.polik.amqp"
        }
)
@EnableEurekaClient
@PropertySources(
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
}
