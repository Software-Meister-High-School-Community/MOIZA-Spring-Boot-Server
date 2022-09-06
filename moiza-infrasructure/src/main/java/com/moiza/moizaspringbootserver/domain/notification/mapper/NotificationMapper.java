package com.moiza.moizaspringbootserver.domain.notification.mapper;

import com.moiza.moizaspringbootserver.domain.notification.domain.NotificationEntity;
import com.moiza.moizaspringbootserver.notification.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationEntity notificationDomainToEntity(Notification notification);
    Notification notificationEntityToDomain(NotificationEntity notificationEntity);
}
