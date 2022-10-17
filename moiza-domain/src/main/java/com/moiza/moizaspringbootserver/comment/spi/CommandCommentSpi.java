package com.moiza.moizaspringbootserver.comment.spi;

import com.moiza.moizaspringbootserver.comment.Comment;
import com.moiza.moizaspringbootserver.feed.Feed;

import java.util.UUID;

public interface CommandCommentSpi {
    void deleteAllComment(Feed feed);

    Comment getCommentById(UUID commentId);
}
