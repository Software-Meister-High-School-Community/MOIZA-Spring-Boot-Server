package com.moiza.moizaspringbootserver.auth.api;

import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainUpdatePasswordRequest;

public interface UpdatePasswordApi {
    void execute(DomainUpdatePasswordRequest request);
}
