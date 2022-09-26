package com.moiza.moizaspringbootserver.auth.api.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainUpdatePasswordRequest {
    private final String newPassword;
    private final String accountId;
    private final String email;
}
