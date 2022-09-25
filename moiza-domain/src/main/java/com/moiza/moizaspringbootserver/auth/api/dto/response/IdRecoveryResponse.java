package com.moiza.moizaspringbootserver.auth.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IdRecoveryResponse {
    private final String accountId;
    private final String name;
}
