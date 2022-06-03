package org.polik.notification.controller;

import org.polik.clients.notification.NotificationRequest;
import org.polik.notification.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Polik on 6/3/2022
 */
@RestController
public record NotificationController(NotificationService service) {

    @PostMapping("/api/v1/notification")
    public void sendNotification(@RequestBody NotificationRequest request) {
        service.send(request);
    }
}
