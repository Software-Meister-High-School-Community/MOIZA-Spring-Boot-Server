package com.moiza.moizaspringbootserver.feed;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Aggregate
public class LocalFeed {

    private final UUID feedId;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;

}
