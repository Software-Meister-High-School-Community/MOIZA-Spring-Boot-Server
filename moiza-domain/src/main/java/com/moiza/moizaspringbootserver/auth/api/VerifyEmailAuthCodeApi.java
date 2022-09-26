package com.moiza.moizaspringbootserver.auth.api;

import com.moiza.moizaspringbootserver.auth.domain.type.Type;

public interface VerifyEmailAuthCodeApi {
    void execute(String email, String authCode, Type type);
}
