package com.moiza.moizaspringbootserver.comment.spi;

import com.moiza.moizaspringbootserver.comment.Comment;

public interface CommandCommentAttachmentFileSpi {
    void deleteCommentAttachmentFile(Comment comment);
}
