package com.moiza.moizaspringbootserver.domain.feed.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_feed_category")
public class FeedCategoryEntity {
    @EmbeddedId
    private FeedCategoryId id;
}
