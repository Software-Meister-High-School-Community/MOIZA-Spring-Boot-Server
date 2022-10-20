package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.api.LocalFeedListApi;
import com.moiza.moizaspringbootserver.feed.api.response.LocalFeedListResponse;
import com.moiza.moizaspringbootserver.feed.api.response.LocalFeedResponse;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import com.moiza.moizaspringbootserver.feed.spi.localfeed.QueryLocalFeedSpi;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class LocalFeedListUseCase implements LocalFeedListApi {
    private final QueryUserSpi queryUserSpi;
    private final AuthSecuritySpi authSecuritySpi;
    private final QueryLocalFeedSpi queryLocalFeedSpi;

    @Override
    public LocalFeedListResponse execute(FeedType feedType, String category) {
        User user = queryUserSpi.queryUserById(authSecuritySpi.getCurrentUserId());
        List<LocalFeedResponse> feeds = queryLocalFeedSpi.getAllLocalFeedByTypeAndKeyword(user, feedType, category)
                .stream()
                .map(it -> LocalFeedResponse.builder()
                        .id(it.getFeedId().toString())
                        .title(it.getTitle())
                        .createdAt(it.getCreatedAt().toString())
                        .build())
                .collect(Collectors.toList());

        return LocalFeedListResponse.builder()
                .feedList(feeds)
                .build();
    }
}
