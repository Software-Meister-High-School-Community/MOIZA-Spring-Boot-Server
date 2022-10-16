package com.moiza.moizaspringbootserver.like;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Aggregate
public class FeedLike {
    private final UUID userId;
    private final UUID feedId;
    private final LocalDateTime createdAt;
}
