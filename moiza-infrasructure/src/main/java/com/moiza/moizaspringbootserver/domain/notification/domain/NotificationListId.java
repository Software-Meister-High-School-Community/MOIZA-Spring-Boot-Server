package com.moiza.moizaspringbootserver.domain.notification.domain;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class NotificationListId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_id", nullable = false)
    private NotificationEntity notificationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @Builder
    public NotificationListId(NotificationEntity notificationEntity, UserEntity userEntity) {
        this.notificationEntity = notificationEntity;
        this.userEntity = userEntity;
    }
}
