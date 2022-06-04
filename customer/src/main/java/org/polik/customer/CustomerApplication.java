package org.polik.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Polik on 5/31/2022
 */
@SpringBootApplication(
        scanBasePackages = {
                "org.polik.customer",
                "org.polik.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(basePackages = "org.polik.clients")
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
