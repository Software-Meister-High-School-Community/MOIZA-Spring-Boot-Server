package com.moiza.moizaspringbootserver.domain.auth.domain;

import com.moiza.moizaspringbootserver.auth.type.Type;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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
}
