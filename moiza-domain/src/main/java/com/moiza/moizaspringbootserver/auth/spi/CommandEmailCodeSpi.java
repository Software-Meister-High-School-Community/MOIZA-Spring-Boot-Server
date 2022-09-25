package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.auth.domain.EmailCode;

public interface CommandEmailCodeSpi {
    void saveAuthCode(EmailCode emailCode);
}
