package com.moiza.moizaspringbootserver.domain.feed.domain;

import com.moiza.moizaspringbootserver.domain.user.domain.UserEntity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class FeedLikeId implements Serializable {
    @ManyToOne
    @JoinColumn
    private FeedEntity feed;

    @ManyToOne
    @JoinColumn
    private UserEntity user;
}
