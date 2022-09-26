package com.moiza.moizaspringbootserver.auth.domain;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import com.moiza.moizaspringbootserver.auth.domain.type.Type;
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

    public EmailCode verify() {
        return EmailCode.builder()
                .email(this.email)
                .authCode(this.authCode)
                .type(this.type)
                .isVerify(true)
                .build();
    }
}
