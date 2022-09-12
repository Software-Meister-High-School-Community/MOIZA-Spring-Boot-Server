package com.moiza.moizaspringbootserver.domain.notification.mapper;

import com.moiza.moizaspringbootserver.domain.notification.domain.NotificationEntity;
import com.moiza.moizaspringbootserver.notification.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public NotificationEntity notificationDomainToEntity(Notification notification) {
        return NotificationEntity.builder()
                .id(notification.getId())
                .title(notification.getTitle())
                .content(notification.getContent())
                .data(notification.getData())
                .type(notification.getType())
                .build();
    }

    @Override
    public Notification notificationEntityToDomain(NotificationEntity notificationEntity) {
        return Notification.builder()
                .id(notificationEntity.getId())
                .title(notificationEntity.getTitle())
                .content(notificationEntity.getContent())
                .data(notificationEntity.getData())
                .type(notificationEntity.getType())
                .build();
    }
}
