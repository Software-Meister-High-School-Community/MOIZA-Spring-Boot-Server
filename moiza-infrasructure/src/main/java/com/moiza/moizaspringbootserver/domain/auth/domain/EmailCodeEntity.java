package com.moiza.moizaspringbootserver.domain.auth.domain;

import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class EmailCodeEntity {

    @Id
    private String email;

    private String authCode;

    @Enumerated(EnumType.STRING)
    private Type type;

    @TimeToLive
    private Long timeToLive;

    private boolean isVerify;

    @Builder
    public EmailCodeEntity(String email, String authCode, Type type, boolean isVerify) {
        this.email = email;
        this.authCode = authCode;
        this.type = type;
        this.timeToLive = 180000L;
        this.isVerify = isVerify;
    }
}
