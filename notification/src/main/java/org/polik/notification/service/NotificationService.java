package org.polik.notification.service;

import lombok.extern.slf4j.Slf4j;
import org.polik.clients.notification.NotificationRequest;
import org.polik.notification.model.Notification;
import org.polik.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by Polik on 6/3/2022
 */
@Slf4j
@Service
public record NotificationService(NotificationRepository repository) {
    public void send(NotificationRequest request) {
        log.info("sendNotification {}", request);
        Notification notification = Notification.builder()
                .message(request.message())
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerEmail())
                .sender("Polik") //fixme:
                .sentAt(LocalDateTime.now())
                .build();

        repository.save(notification);
    }
}
