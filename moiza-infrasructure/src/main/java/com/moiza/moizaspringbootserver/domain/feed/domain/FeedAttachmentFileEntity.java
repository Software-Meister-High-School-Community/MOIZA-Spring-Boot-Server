package com.moiza.moizaspringbootserver.domain.feed.domain;

import com.moiza.moizaspringbootserver.global.entity.BaseUUIDEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed_attachment_file")
public class FeedAttachmentFileEntity extends BaseUUIDEntity {

    @NotNull
    @Length(max = 256)
    private String attachmentFileUrl;

    @JoinColumn(name = "feed_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private FeedEntity feed;
}
