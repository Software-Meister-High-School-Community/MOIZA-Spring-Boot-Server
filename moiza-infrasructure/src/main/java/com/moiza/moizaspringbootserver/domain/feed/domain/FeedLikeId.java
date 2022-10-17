package com.moiza.moizaspringbootserver.domain.feed.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class FeedCategoryId implements Serializable {
    private Integer feed;

    private Integer category;
}
