package com.moiza.moizaspringbootserver.auth.api;

import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainIdValidationRequest;

public interface IdValidationApi {
    void validId(DomainIdValidationRequest request);
}
