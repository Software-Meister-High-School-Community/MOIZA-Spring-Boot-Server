package com.moiza.moizaspringbootserver.auth;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import com.moiza.moizaspringbootserver.auth.type.Type;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class EmailCode {

    private final String email;
    private final String authCode;
    private final Type type;
    private final boolean isVerify;
    private final Long timeToLive;
}
