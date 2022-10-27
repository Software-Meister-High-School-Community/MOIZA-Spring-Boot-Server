package com.moiza.moizaspringbootserver.domain.comment.mapper;

import com.moiza.moizaspringbootserver.comment.CommentAttachmentFile;
import com.moiza.moizaspringbootserver.comment.exception.CommentNotFoundException;
import com.moiza.moizaspringbootserver.domain.comment.domain.CommentAttachmentFileEntity;
import com.moiza.moizaspringbootserver.domain.comment.domain.CommentEntity;
import com.moiza.moizaspringbootserver.domain.comment.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentAttachmentFileImpl implements CommentAttachmentFileMapper {

	private final CommentRepository commentRepository;

	@Override
	public CommentAttachmentFileEntity commentAttachmentFileDomainToEntity(
		CommentAttachmentFile commentAttachmentFile) {
		CommentEntity commentEntity = commentRepository.findById(commentAttachmentFile.getCommentId())
			.orElseThrow(() -> CommentNotFoundException.EXCEPTION);

		return CommentAttachmentFileEntity.builder()
			.id(commentAttachmentFile.getId())
			.attachmentFileUrl(commentAttachmentFile.getAttachmentFileUrl())
			.commentEntity(commentEntity)
			.build();
	}

	@Override
	public CommentAttachmentFile commentAttachmentFileEntityToDomain(
		CommentAttachmentFileEntity commentAttachmentFileEntity) {
		return CommentAttachmentFile.builder()
			.id(commentAttachmentFileEntity.getId())
			.attachmentFileUrl(commentAttachmentFileEntity.getAttachmentFileUrl())
			.commentId(commentAttachmentFileEntity.getCommentEntity().getId())
			.build();
	}
}
