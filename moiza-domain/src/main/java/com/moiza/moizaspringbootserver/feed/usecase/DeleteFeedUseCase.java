package com.moiza.moizaspringbootserver.feed.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.exception.InvalidRoleException;
import com.moiza.moizaspringbootserver.auth.spi.AuthSecuritySpi;
import com.moiza.moizaspringbootserver.comment.Comment;
import com.moiza.moizaspringbootserver.comment.spi.CommentAttachmentFileSpi;
import com.moiza.moizaspringbootserver.comment.spi.CommentSpi;
import com.moiza.moizaspringbootserver.feed.Feed;
import com.moiza.moizaspringbootserver.feed.api.DeleteFeedApi;
import com.moiza.moizaspringbootserver.feed.spi.feed.FeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.feedattachmentfile.FeedAttachmentFileSpi;
import com.moiza.moizaspringbootserver.feed.spi.feedcategory.FeedCategorySpi;
import com.moiza.moizaspringbootserver.feed.spi.localfeed.LocalFeedSpi;
import com.moiza.moizaspringbootserver.feed.spi.publicfeed.PublicFeedSpi;
import com.moiza.moizaspringbootserver.like.spi.FeedLikeSpi;
import com.moiza.moizaspringbootserver.user.domain.User;
import com.moiza.moizaspringbootserver.user.spi.UserSpi;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@UseCase
public class DeleteFeedUseCase implements DeleteFeedApi {

    private final AuthSecuritySpi authSecuritySpi;
    private final PublicFeedSpi publicFeedSpi;
    private final LocalFeedSpi localFeedSpi;
    private final FeedSpi feedSpi;
    private final FeedLikeSpi feedLikeSpi;
    private final FeedCategorySpi feedCategorySpi;
    private final FeedAttachmentFileSpi feedAttachmentFileSpi;
    private final CommentAttachmentFileSpi commentAttachmentFileSpi;
    private final CommentSpi commentSpi;
    private final UserSpi userSpi;

    @Override
    public void execute(UUID feedId) {

        User user = userSpi.queryUserById(authSecuritySpi.getCurrentUserId());
        Feed feed = feedSpi.getFeedById(feedId);
        Comment comment = commentSpi.getCommentById(feedId);

        if (!user.equals(feed.getUserId())) {
            throw InvalidRoleException.EXCEPTION;
        }

        publicFeedSpi.publicFeedDelete(feed);
        localFeedSpi.localFeedDelete(feed);
        feedSpi.feedDelete(feed);
        feedLikeSpi.deleteFeedLike(feed);
        feedCategorySpi.deleteCategory(feed);
        feedAttachmentFileSpi.feedAttachmentFileDelete(feed);
        commentAttachmentFileSpi.deleteCommentAttachmentFile(comment);
        commentSpi.deleteComment(feed);

    }
}
