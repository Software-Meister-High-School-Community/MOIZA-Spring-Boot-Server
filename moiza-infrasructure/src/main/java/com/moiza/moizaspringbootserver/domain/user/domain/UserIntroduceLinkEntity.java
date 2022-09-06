package com.moiza.moizaspringbootserver.domain.user.domain;

import com.moiza.moizaspringbootserver.global.entity.BaseUUIDEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_user")
public class UserIntroduceLinkEntity extends BaseUUIDEntity {

	@Column(nullable = false)
	private String linkUrl;

	@JoinColumn(name = "user_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntity userEntity;
}
