package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.api.SuggestionsFeedListApi;
import com.moiza.moizaspringbootserver.feed.api.dto.response.SuggestionsFeedListResponse;
import com.moiza.moizaspringbootserver.feed.api.dto.response.SuggestionsFeedListResponse.SuggestionsFeed;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class SuggestionsFeedListUseCase implements SuggestionsFeedListApi {

    private final AuthSecuritySpi authSecuritySpi;

    @Override
    public SuggestionsFeedListResponse execute(String category) {
        UUID currentUserId = authSecuritySpi.getCurrentUserId();

        List<SuggestionsFeed> feedLis = SuggestionsFeed.builder()
                .id()
                .title()
                .type()
                .createdAt()
                .authorName();

        return new SuggestionsFeedListResponse(feedList);
    }
}
