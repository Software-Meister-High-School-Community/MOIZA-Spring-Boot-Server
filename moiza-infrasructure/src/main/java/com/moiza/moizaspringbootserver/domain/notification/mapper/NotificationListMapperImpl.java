package com.moiza.moizaspringbootserver.domain.notification.mapper;

import com.moiza.moizaspringbootserver.domain.notification.domain.NotificationEntity;
import com.moiza.moizaspringbootserver.domain.notification.domain.NotificationListEntity;
import com.moiza.moizaspringbootserver.domain.notification.domain.NotificationListId;
import com.moiza.moizaspringbootserver.domain.notification.domain.repository.NotificationRepository;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.notification.NotificationList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class NotificationListMapperImpl implements NotificationListMapper {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Override
    public NotificationListEntity notificationListDomainToEntity(NotificationList notificationList) {
        return new NotificationListEntity(
                new NotificationListId(
                        findByNotificationId(notificationList.getNotificationId()),
                        findByUserId(notificationList.getUserId())
                )
        );
    }

    @Override
    public NotificationList notificationListEntityToDomain(NotificationListEntity notificationListEntity) {
        return NotificationList.builder()
                .notificationId(notificationListEntity.getId().getNotificationEntity().getId())
                .userId(notificationListEntity.getId().getUserEntity().getId())
                .build();
    }

    private NotificationEntity findByNotificationId(UUID id) {
        return notificationRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    private UserEntity findByUserId(UUID id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
