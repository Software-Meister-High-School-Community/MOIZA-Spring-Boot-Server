package com.moiza.moizaspringbootserver.domain.notification.mapper;

import com.moiza.moizaspringbootserver.domain.notification.domain.NotificationEntity;
import com.moiza.moizaspringbootserver.notification.Notification;

public interface NotificationMapper {
    NotificationEntity notificationDomainToEntity(Notification notification);
    Notification notificationEntityToDomain(NotificationEntity notificationEntity);
}
