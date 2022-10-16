package com.moiza.moizaspringbootserver.comment.spi;

import com.moiza.moizaspringbootserver.comment.Comment;
import com.moiza.moizaspringbootserver.feed.Feed;

public interface CommandCommentAttachmentFileSpi {
    void deleteCommentAttachmentFile(Comment comment);
}
