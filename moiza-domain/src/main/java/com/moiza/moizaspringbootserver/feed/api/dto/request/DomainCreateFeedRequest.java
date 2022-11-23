package com.moiza.moizaspringbootserver.feed.api.dto.request;

import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class DomainCreateFeedRequest {

    private String title;

    private String content;

    private FeedType feedType;

    private String category;

    private List<String> imageUrls;
}
