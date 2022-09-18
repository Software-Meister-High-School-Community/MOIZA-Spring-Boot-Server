package com.moiza.moizaspringbootserver.auth;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import com.moiza.moizaspringbootserver.auth.type.Type;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Aggregate
public class EmailCode {

    private String email;
    private String authCode;
    private Type type;
}
