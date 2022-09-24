package com.moiza.moizaspringbootserver.auth.api.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainIdValidationRequest {
    private String accountId;
}
