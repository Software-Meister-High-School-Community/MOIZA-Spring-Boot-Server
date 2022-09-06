package com.moiza.moizaspringbootserver.notification;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class NotificationList {

    private final UUID notificationId;
    private final UUID userId;
}
