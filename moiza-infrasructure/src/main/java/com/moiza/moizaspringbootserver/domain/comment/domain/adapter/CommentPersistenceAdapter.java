package com.moiza.moizaspringbootserver.domain.comment.domain.adapter;

import com.moiza.moizaspringbootserver.comment.Comment;
import com.moiza.moizaspringbootserver.comment.exception.CommentNotFoundException;
import com.moiza.moizaspringbootserver.comment.spi.CommentSpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.domain.comment.domain.repository.CommentRepository;
import com.moiza.moizaspringbootserver.domain.comment.mapper.CommentMapper;
import com.moiza.moizaspringbootserver.domain.feed.mapper.FeedMapper;
import com.moiza.moizaspringbootserver.feed.Feed;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Adapter
public class CommentPersistenceAdapter implements CommentSpi {

    private final FeedMapper feedMapper;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;

    @Override
    public void deleteComment(Feed feed) {
        commentRepository.deleteByFeedEntity(
                feedMapper.feedDomainToEntity(feed)
        );
    }

    @Override
    public Comment getCommentById(UUID commentId) {
        return commentMapper.commentEntityToDomain(
                commentRepository.findById(commentId)
                        .orElseThrow(() -> CommentNotFoundException.EXCEPTION)
        );
    }
}
