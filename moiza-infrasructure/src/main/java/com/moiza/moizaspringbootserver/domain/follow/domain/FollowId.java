package com.moiza.moizaspringbootserver.domain.follow.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@EqualsAndHashCode
public class FollowId implements Serializable {

    private UUID user;

    private LocalDateTime createdAt;

    private UUID targetUser;

    @Builder
    public FollowId(UUID user, LocalDateTime createdAt, UUID targetUser) {
        this.user = user;
        this.createdAt = createdAt;
        this.targetUser = targetUser;
    }
}

