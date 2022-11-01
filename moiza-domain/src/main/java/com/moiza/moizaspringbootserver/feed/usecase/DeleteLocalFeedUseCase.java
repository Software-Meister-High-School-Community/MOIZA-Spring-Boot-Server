package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.exception.InvalidRoleException;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.api.DeleteLocalFeedApi;
import com.moiza.moizaspringbootserver.feed.spi.feed.CommandFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.feed.QueryFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.localfeed.CommandLocalFeedSpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DeleteLocalFeedUseCase implements DeleteLocalFeedApi {

    private final CommandLocalFeedSpi commandLocalFeedSpi;
    private final QueryFeedSpi queryFeedSpi;
    private final CommandFeedSpi commandFeedSpi;
    private final AuthSecuritySpi authSecuritySpi;
    private final QueryUserSpi queryUserSpi;

    @Override
    public void execute(UUID feedId) {
        UUID userId = authSecuritySpi.getCurrentUserId();
        Feed feed = queryFeedSpi.getFeedById(feedId);

        if (queryUserSpi.existsUserById(userId))
            throw InvalidRoleException.EXCEPTION;

        commandLocalFeedSpi.deleteLocalFeedByFeedId(feed);
        commandFeedSpi.deleteFeedByFeedId(feed);
    }
}
