package com.moiza.moizaspringbootserver.domain.feed.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_public_feed")
public class PublicFeedEntity extends CommonFeedEntity {

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @NotNull
    private Integer likeCount = 0;

    @NotNull
    private Integer viewCount = 0;
}
