package com.moiza.moizaspringbootserver.domain.notice.domain;

import com.moiza.moizaspringbootserver.global.entity.BaseUUIDEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableWebSecurity
@Table(name = "notice_attachment_file")
public class NoticeAttachmentFileEntity extends BaseUUIDEntity {

    @NotNull
    private String attachmentFileUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private NoticeEntity noticeEntity;

}
