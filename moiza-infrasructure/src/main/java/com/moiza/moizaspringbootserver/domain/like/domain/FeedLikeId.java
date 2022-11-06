package com.moiza.moizaspringbootserver.domain.like.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
public class FeedLikeId implements Serializable {

    private UUID user;

    private UUID feed;

    private LocalDateTime createdAt;

}
