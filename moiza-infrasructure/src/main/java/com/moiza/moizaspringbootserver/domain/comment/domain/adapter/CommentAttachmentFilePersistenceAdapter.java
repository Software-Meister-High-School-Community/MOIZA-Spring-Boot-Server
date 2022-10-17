package com.moiza.moizaspringbootserver.domain.comment.domain.adapter;

import com.moiza.moizaspringbootserver.comment.Comment;
import com.moiza.moizaspringbootserver.comment.spi.CommentAttachmentFileSpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.comment.domain.repository.CommentAttachmentFileRepository;
import com.moiza.moizaspringbootserver.domain.comment.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class CommentAttachmentFilePersistenceAdapter implements CommentAttachmentFileSpi {

    private final CommentMapper commentMapper;
    private final CommentAttachmentFileRepository commentAttachmentFileRepository;

    @Override
    public void deleteCommentAttachmentFile(Comment comment) {
        commentAttachmentFileRepository.deleteByCommentEntity(
                commentMapper.commentDomainToEntity(comment)
        );
    }
}
