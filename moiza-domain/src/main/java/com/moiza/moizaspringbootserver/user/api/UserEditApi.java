package com.moiza.moizaspringbootserver.user.api;

import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserEditRequest;

public interface UserEditApi {
    void execute(DomainUserEditRequest request);
}
