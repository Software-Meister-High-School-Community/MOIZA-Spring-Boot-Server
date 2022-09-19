package com.moiza.moizaspringbootserver.follow;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Aggregate
public class Follow {
    private final UUID userId;
    private final LocalDateTime createdAt;
    private final UUID targetUserId;
}
