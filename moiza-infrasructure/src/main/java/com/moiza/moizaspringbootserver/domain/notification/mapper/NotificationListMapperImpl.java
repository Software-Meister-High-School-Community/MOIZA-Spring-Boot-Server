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
                NotificationListId.builder()
                        .notificationEntity(findByNotificationId(notificationList.getNotificationId()))
                        .userEntity(findByUserId(notificationList.getUserId()))
                        .build()
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
        return notificationRepository.findById(id).orElseThrow(RuntimeException::new); //TODO 담당자 Exception 만들어서 추가
    }

    private UserEntity findByUserId(UUID id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new); //TODO 담당자 Exception 만들어서 추가
    }
}
