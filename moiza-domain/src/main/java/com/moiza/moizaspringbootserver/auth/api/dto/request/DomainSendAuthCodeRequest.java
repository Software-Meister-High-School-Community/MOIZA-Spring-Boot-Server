package com.moiza.moizaspringbootserver.auth.api.dto.request;

import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DomainSendAuthCodeRequest {

    private final Type type;
    private final String value;
}
