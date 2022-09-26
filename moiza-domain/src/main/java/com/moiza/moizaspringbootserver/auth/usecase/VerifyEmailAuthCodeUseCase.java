package com.moiza.moizaspringbootserver.auth.usecase;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import com.moiza.moizaspringbootserver.auth.api.VerifyEmailAuthCodeApi;
import com.moiza.moizaspringbootserver.auth.domain.EmailCode;
import com.moiza.moizaspringbootserver.auth.domain.type.Type;
import com.moiza.moizaspringbootserver.auth.exception.AuthCodeAlreadyVerifiedException;
import com.moiza.moizaspringbootserver.auth.spi.CommandEmailCodeSpi;
import com.moiza.moizaspringbootserver.auth.spi.QueryEmailCodeSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class VerifyEmailAuthCodeUseCase implements VerifyEmailAuthCodeApi {

    private final QueryEmailCodeSpi queryEmailCodeSpi;
    private final CommandEmailCodeSpi commandEmailCodeSpi;

    @Override
    public void execute(String email, String authCode, Type type) {
        EmailCode emailCode = queryEmailCodeSpi.queryEmailCodeByEmailAndType(email, type);

        if (emailCode.isVerify()) {
            throw AuthCodeAlreadyVerifiedException.EXCEPTION;
        }

        commandEmailCodeSpi.saveAuthCode(
                emailCode.verify()
        );
    }
}
