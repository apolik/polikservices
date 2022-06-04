package org.polik.notification.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.polik.clients.notification.NotificationRequest;
import org.polik.notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Polik on 6/4/2022
 */
@Slf4j
@Component
@AllArgsConstructor
public class NotificationListener {
    private final NotificationService service;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void listen(NotificationRequest notificationRequest) {
        log.info("Message received: {}", notificationRequest);
        service.send(notificationRequest);
    }
}
