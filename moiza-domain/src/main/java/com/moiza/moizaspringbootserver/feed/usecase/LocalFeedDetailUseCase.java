package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.exception.InvalidRoleException;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.LocalFeed;
import com.moiza.moizaspringbootserver.feed.api.LocalFeedDetailApi;
import com.moiza.moizaspringbootserver.feed.api.dto.response.LocalFeedDetailResponse;
import com.moiza.moizaspringbootserver.feed.spi.feed.QueryFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.localfeed.QueryLocalFeedSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class LocalFeedDetailUseCase implements LocalFeedDetailApi {
    private final AuthSecuritySpi authSecuritySpi;
    private final QueryFeedSpi queryFeedSpi;
    private final QueryLocalFeedSpi queryLocalFeedSpi;

    @Override
    public LocalFeedDetailResponse execute(UUID feedId) {
        UUID queryUserId = authSecuritySpi.getCurrentUserId();
        Feed feed = queryFeedSpi.getFeedById(feedId);
        LocalFeed localFeed = queryLocalFeedSpi.getFeedById(feedId);

        if(feed.getUserId().equals(queryUserId))
            throw InvalidRoleException.EXCEPTION;

        return LocalFeedDetailResponse.builder()
                .title(localFeed.getTitle())
                .content(localFeed.getContent())
                .feedType(feed.getFeedType())
                .category(queryFeedSpi.getCategoryName(feed.getId()))
                .build();
    }
}
