package com.moiza.moizaspringbootserver.domain.comment.mapper;

import com.moiza.moizaspringbootserver.comment.Comment;
import com.moiza.moizaspringbootserver.comment.exception.CommentNotFoundException;
import com.moiza.moizaspringbootserver.domain.comment.domain.CommentEntity;
import com.moiza.moizaspringbootserver.domain.comment.domain.repository.CommentRepository;
import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.feed.domain.repository.FeedRepository;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.repository.UserRepository;
import com.moiza.moizaspringbootserver.feed.exception.FeedNotFoundException;
import com.moiza.moizaspringbootserver.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentMapperImpl implements CommentMapper{

	private final UserRepository userRepository;
	private final FeedRepository feedRepository;
	private final CommentRepository commentRepository;

	@Override
	public CommentEntity commentDomainToEntity(Comment comment) {
		UserEntity userEntity = userRepository.findById(comment.getUserId())
			.orElseThrow(() -> UserNotFoundException.EXCEPTION);
		FeedEntity feedEntity = feedRepository.findById(comment.getFeedId())
			.orElseThrow(() -> FeedNotFoundException.EXCEPTION);
		CommentEntity commentEntity = commentRepository.findById(comment.getParentCommentId())
			.orElseThrow(() -> CommentNotFoundException.EXCEPTION);

		return CommentEntity.builder()
			.id(comment.getId())
			.content(comment.getContent())
			.isPinned(comment.isPinned())
			.userEntity(userEntity)
			.feedEntity(feedEntity)
			.commentEntity(commentEntity)
			.build();
	}

	@Override
	public Comment commentEntityToDomain(CommentEntity commentEntity) {
		return Comment.builder()
			.id(commentEntity.getId())
			.content(commentEntity.getContent())
			.isPinned(commentEntity.isPinned())
			.createAt(commentEntity.getCreatedAt())
			.updatedAt(commentEntity.getUpdatedAt())
			.userId(commentEntity.getUserEntity().getId())
			.feedId(commentEntity.getFeedEntity().getId())
			.parentCommentId(commentEntity.getCommentEntity().getId())
			.build();
	}
}
