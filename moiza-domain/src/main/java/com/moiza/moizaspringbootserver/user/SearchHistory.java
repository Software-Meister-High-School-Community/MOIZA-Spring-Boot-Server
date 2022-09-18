package com.moiza.moizaspringbootserver.user;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Aggregate
public class SearchHistory {
    private final UUID id;
    private final String keyword;
    private final LocalDateTime createdAt;
    private final UUID userId;
}
