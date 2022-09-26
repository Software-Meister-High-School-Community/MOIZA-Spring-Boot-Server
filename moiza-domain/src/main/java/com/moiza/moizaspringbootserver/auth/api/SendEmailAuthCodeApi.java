package com.moiza.moizaspringbootserver.auth.api;

import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainSendAuthCodeRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.response.SendEmailAuthCodeResponse;

public interface SendEmailAuthCodeApi {
    SendEmailAuthCodeResponse execute(DomainSendAuthCodeRequest request);
}
