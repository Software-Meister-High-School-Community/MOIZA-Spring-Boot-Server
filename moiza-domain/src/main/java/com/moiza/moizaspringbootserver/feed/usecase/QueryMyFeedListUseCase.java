package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.MyFeedListResponse;
import com.moiza.moizaspringbootserver.feed.api.QueryMyFeedListApi;
import com.moiza.moizaspringbootserver.feed.spi.dto.response.MyFeedListResponse.FeedResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class QueryMyFeedListUseCase implements QueryMyFeedListApi {

    private final AuthSecuritySpi authSecuritySpi;

    @Override
    public MyFeedListResponse execute(String category, FeedType type, String order, int page) {
        UUID userId = authSecuritySpi.getCurrentUserId();

        return null;
    }

    private MyFeedListResponse getFeedList(String category, FeedType type, String order, int page) {

        return null;
    }
}
