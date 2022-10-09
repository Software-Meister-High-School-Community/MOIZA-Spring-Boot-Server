package com.moiza.moizaspringbootserver.domain.feed.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FeedLikeEntity {
    @EmbeddedId
    private FeedLikeId id;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
