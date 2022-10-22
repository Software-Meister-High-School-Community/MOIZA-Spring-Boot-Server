package com.moiza.moizaspringbootserver.like.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.like.FeedLike;
import com.moiza.moizaspringbootserver.like.api.DiscardFeedLikeApi;
import com.moiza.moizaspringbootserver.like.exception.FeedLikeNotFoundException;
import com.moiza.moizaspringbootserver.like.spi.CommandFeedLikeSpi;
import com.moiza.moizaspringbootserver.like.spi.FeedLikeQuerySpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DiscardFeedLikeUseCase implements DiscardFeedLikeApi {
    private final AuthSecuritySpi authSecuritySpi;
    private final CommandFeedLikeSpi commandFeedLikeSpi;
    private final FeedLikeQuerySpi feedLikeQuerySpi;

    @Override
    public void execute(UUID feedId) {
        UUID userId = authSecuritySpi.getCurrentUserId();
        if(!feedLikeQuerySpi.existsByFeedIdAndUserId(feedId, userId))
            throw FeedLikeNotFoundException.EXCEPTION;

        FeedLike feedLike = feedLikeQuerySpi.getFeedLike(feedId, userId);
        commandFeedLikeSpi.deleteFeedLike(feedLike);
    }
}
