package com.moiza.moizaspringbootserver.domain.like.domain;

import com.moiza.moizaspringbootserver.domain.feed.domain.FeedEntity;
import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;
import com.moiza.moizaspringbootserver.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Entity
@Table(name = "tbl_feed_like")
public class FeedLikeEntity extends BaseTimeEntity {

    @EmbeddedId
    private FeedLikeId id;

    @MapsId("user")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @MapsId("feed")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private FeedEntity feed;

}
