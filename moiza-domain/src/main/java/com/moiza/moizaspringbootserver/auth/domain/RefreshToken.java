package com.moiza.moizaspringbootserver.auth.domain;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class RefreshToken {

    private final String email;
    private final String refreshToken;
    private final Long timeToLive;

    public RefreshToken update(String email, Long timeToLive) {
        return RefreshToken.builder()
                .email(email)
                .refreshToken(refreshToken)
                .timeToLive(timeToLive)
                .build();
    }

}
