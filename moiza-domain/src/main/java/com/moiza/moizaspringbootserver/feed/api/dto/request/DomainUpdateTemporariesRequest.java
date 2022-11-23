package com.moiza.moizaspringbootserver.feed.api.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainUpdateTemporariesRequest {
    private final String title;
    private final String content;
}
