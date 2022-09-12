package com.moiza.moizaspringbootserver.notification;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import com.moiza.moizaspringbootserver.notification.type.Type;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class Notification {

    private final UUID id;
    private final String title;
    private final String content;
    private final String data;
    private final Type type;
}
