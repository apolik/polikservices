package org.polik.clients.notification;

/**
 * Created by Polik on 6/3/2022
 */
public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String message
) {
}
