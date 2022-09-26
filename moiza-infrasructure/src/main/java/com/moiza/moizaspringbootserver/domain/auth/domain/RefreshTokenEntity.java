package com.moiza.moizaspringbootserver.domain.auth.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class RefreshTokenEntity {

    @Id
    private String email;

    @Indexed
    private String refreshToken;

    private Long timeToLive;

    @Builder
    public RefreshTokenEntity(String email, String refreshToken, Long timeToLive) {
        this.email = email;
        this.refreshToken = refreshToken;
        this.timeToLive = timeToLive;
    }
}
