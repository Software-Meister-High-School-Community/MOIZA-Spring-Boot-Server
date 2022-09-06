package com.moiza.moizaspringbootserver.domain.notification.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_notification_list")
public class NotificationListEntity {

    @EmbeddedId
    private NotificationListId id;
}
