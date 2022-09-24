package com.moiza.moizaspringbootserver.auth.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomainIdValidationRequest {
    private String accountId;
}
