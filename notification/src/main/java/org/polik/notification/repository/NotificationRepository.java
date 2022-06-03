package org.polik.notification.repository;

import org.polik.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Polik on 2/1/2022
 */
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
