package com.moiza.moizaspringbootserver.domain.notification.mapper;

import com.moiza.moizaspringbootserver.domain.notification.domain.NotificationListEntity;
import com.moiza.moizaspringbootserver.notification.NotificationList;

public interface NotificationListMapper {
    NotificationListEntity notificationListDomainToEntity(NotificationList notificationList);
    NotificationList notificationListEntityToDomain(NotificationListEntity notificationListEntity);
}
