package com.moiza.moizaspringbootserver.feed.spi.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PublishedFeedPage {
    private Long totalPages;
    private List<PublishedFeedResponse> feeds;
}
