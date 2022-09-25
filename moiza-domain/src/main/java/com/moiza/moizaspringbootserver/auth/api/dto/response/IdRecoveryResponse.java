package com.moiza.moizaspringbootserver.auth.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class IdRecoveryResponse {
    private String accountId;
    private String name;
}
