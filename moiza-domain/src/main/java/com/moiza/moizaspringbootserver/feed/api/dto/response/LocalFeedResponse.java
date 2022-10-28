package com.moiza.moizaspringbootserver.feed.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LocalFeedResponse {
    private String id;
    private String title;
    private LocalDateTime createdAt;
}
