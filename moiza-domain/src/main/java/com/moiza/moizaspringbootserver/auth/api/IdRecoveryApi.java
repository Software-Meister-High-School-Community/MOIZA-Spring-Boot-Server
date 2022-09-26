package com.moiza.moizaspringbootserver.auth.api;

import com.moiza.moizaspringbootserver.auth.api.dto.response.IdRecoveryResponse;

public interface IdRecoveryApi {
    IdRecoveryResponse execute(String email);
}
