package com.moiza.moizaspringbootserver.domain.feed.domain;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class FeedCategoryId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "feed_id")
    private FeedEntity feed;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
