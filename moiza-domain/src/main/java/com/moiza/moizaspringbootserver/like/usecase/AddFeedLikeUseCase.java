package com.moiza.moizaspringbootserver.like.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.spi.feed.FeedSpi;
import com.moiza.moizaspringbootserver.like.FeedLike;
import com.moiza.moizaspringbootserver.like.api.AddFeedLikeApi;
import com.moiza.moizaspringbootserver.like.exception.FeedLikeAlreadyExistsException;
import com.moiza.moizaspringbootserver.like.spi.CommandFeedLikeSpi;
import com.moiza.moizaspringbootserver.like.spi.FeedLikeSpi;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class AddFeedLikeUseCase implements AddFeedLikeApi {

    private final CommandFeedLikeSpi commandFeedLikeSpi;
    private final AuthSecuritySpi authSecuritySpi;
    private final FeedSpi feedSpi;
    private final FeedLikeSpi feedLikeSpi;

    @Override
    public void execute(UUID feedId) {
        UUID userId = authSecuritySpi.getCurrentUserId();
        Feed feed = feedSpi.getFeedById(feedId);

        if (feedLikeSpi.existsByFeedIdAndUserId(feed.getId(), userId)) {
            throw FeedLikeAlreadyExistsException.EXCEPTION;
        }

        commandFeedLikeSpi.saveFeedLike(
                FeedLike.builder()
                        .userId(userId)
                        .feedId(feedId)
                        .createdAt(LocalDateTime.now())
                .build());
    }
}
