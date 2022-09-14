package com.moiza.moizaspringbootserver.domain.comment.mapper;

import com.moiza.moizaspringbootserver.comment.CommentAttatchmentFile;
import com.moiza.moizaspringbootserver.comment.exception.CommentNotFoundException;
import com.moiza.moizaspringbootserver.domain.comment.CommentAttatchmentFileEntity;
import com.moiza.moizaspringbootserver.domain.comment.CommentEntity;
import com.moiza.moizaspringbootserver.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentAttatchmentFileImpl implements CommentAttatchmentFileMapper{

	private final CommentRepository commentRepository;

	@Override
	public CommentAttatchmentFileEntity commentAttatchmentFileDomainToEntity(
		CommentAttatchmentFile commentAttatchmentFile) {
		CommentEntity commentEntity = commentRepository.findById(commentAttatchmentFile.getCommentId())
			.orElseThrow(() -> CommentNotFoundException.EXCEPTION);

		return CommentAttatchmentFileEntity.builder()
			.id(commentAttatchmentFile.getId())
			.attatchmentFileUrl(commentAttatchmentFile.getAttatchmentFileUrl())
			.commentEntity(commentEntity)
			.build();
	}

	@Override
	public CommentAttatchmentFile commentAttatchmentFileEntityToDomain(
		CommentAttatchmentFileEntity commentAttatchmentFileEntity) {
		return CommentAttatchmentFile.builder()
			.id(commentAttatchmentFileEntity.getId())
			.attatchmentFileUrl(commentAttatchmentFileEntity.getAttatchmentFileUrl())
			.commentId(commentAttatchmentFileEntity.getCommentEntity().getId())
			.build();
	}
}
