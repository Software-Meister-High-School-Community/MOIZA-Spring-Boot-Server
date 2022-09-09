package com.moiza.moizaspringbootserver.domain.feed.domain;

import com.moiza.moizaspringbootserver.global.entity.BaseTimeEntity;
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
@Table(name = "tbl_local_feed")
public class LocalFeedEntity extends BaseTimeEntity {

    @MapsId
    @JoinColumn(name = "feed_id")
    @OneToOne
    private FeedEntity feed;

    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 500)
    private String content;
}
