package org.polik.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Polik on 2/1/2022
 */
@FeignClient("notification")
public interface NotificationClient {
    @PostMapping("/api/v1/notification")
    void sendNotification(NotificationRequest request);
}
