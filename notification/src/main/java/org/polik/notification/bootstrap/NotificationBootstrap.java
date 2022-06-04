package org.polik.notification.bootstrap;

import lombok.AllArgsConstructor;
import org.polik.amqp.producer.RabbitMQMessageProducer;
import org.polik.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Polik on 6/4/2022
 */
@Component
@AllArgsConstructor
public class NotificationBootstrap implements CommandLineRunner {
    private final RabbitMQMessageProducer messageProducer;
    private final NotificationConfig notificationConfig;

    @Override
    public void run(String... args) throws Exception {
        messageProducer.publish(
                "test payload",
                notificationConfig.getInternalExchange(),
                notificationConfig.getInternalNotificationRoutingKey()
        );
    }
}
