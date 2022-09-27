package com.moiza.moizaspringbootserver.domain.comment.domain;

import com.moiza.moizaspringbootserver.global.entity.BaseUUIDEntity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_comment_attatchment_file")
public class CommentAttatchmentFileEntity extends BaseUUIDEntity {

	@NotNull
	private String attatchmentFileUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comment_id")
	private CommentEntity commentEntity;
}
