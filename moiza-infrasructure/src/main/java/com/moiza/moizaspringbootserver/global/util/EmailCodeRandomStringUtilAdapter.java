package com.moiza.moizaspringbootserver.global.util;

import com.moiza.moizaspringbootserver.auth.spi.EmailCodeRandomStringSpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import org.apache.commons.lang3.RandomStringUtils;

@Adapter
public class EmailCodeRandomStringUtilAdapter implements EmailCodeRandomStringSpi {

    @Override
    public String getEmailAuthCode() {
        return RandomStringUtils.randomNumeric(6);
    }
}
