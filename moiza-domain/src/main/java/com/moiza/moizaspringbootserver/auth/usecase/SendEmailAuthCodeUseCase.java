package com.moiza.moizaspringbootserver.auth.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.api.SendEmailAuthCodeApi;
import com.moiza.moizaspringbootserver.auth.api.dto.request.DomainSendAuthCodeRequest;
import com.moiza.moizaspringbootserver.auth.api.dto.response.SendEmailAuthCodeResponse;
import com.moiza.moizaspringbootserver.auth.domain.EmailCode;
import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import com.moiza.moizaspringbootserver.auth.exception.AuthCodeAlreadyVerifiedException;
import com.moiza.moizaspringbootserver.auth.spi.CommandEmailCodeSpi;
import com.moiza.moizaspringbootserver.auth.spi.EmailCodeRandomStringSpi;
import com.moiza.moizaspringbootserver.auth.spi.QueryEmailCodeSpi;
import com.moiza.moizaspringbootserver.auth.spi.SendEmailSpi;
import com.moiza.moizaspringbootserver.user.spi.QueryUserSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SendEmailAuthCodeUseCase implements SendEmailAuthCodeApi {

    private final SendEmailSpi sendEmailSpi;
    private final CommandEmailCodeSpi commandEmailCodeSpi;
    private final EmailCodeRandomStringSpi emailCodeRandomStringSpi;
    private final QueryEmailCodeSpi queryEmailCodeSpi;
    private final QueryUserSpi queryUserSpi;

    @Override
    public SendEmailAuthCodeResponse execute(DomainSendAuthCodeRequest request) {
        Type type = request.getType();
        String email = getEmail(type, request.getValue());
        String authCode = emailCodeRandomStringSpi.getEmailAuthCode();
        EmailCode emailCode = queryEmailCodeSpi.queryEmailCodeByEmailAndType(email, type);

        if (emailCode.isVerify()) {
            throw AuthCodeAlreadyVerifiedException.EXCEPTION;
        }

        commandEmailCodeSpi.saveAuthCode(buildEmailCode(email, authCode, type));
        sendEmailSpi.sendEmail(email, authCode);

        return new SendEmailAuthCodeResponse(email);
    }

    private String getEmail(Type type, String value) {
        if (Type.PASSWORD.equals(type)) {
            return queryUserSpi.queryGetEmailByAccountId(value);
        } else {
            return value;
        }
    }

    private EmailCode buildEmailCode(String email, String authCode, Type type) {
        return EmailCode.builder()
                .email(email)
                .authCode(authCode)
                .type(type)
                .isVerify(false)
                .build();
    }
}
