package com.moiza.moizaspringbootserver.auth.spi;

import com.moiza.moizaspringbootserver.auth.domain.EmailCode;
import com.moiza.moizaspringbootserver.auth.domain.type.Type;

public interface QueryEmailCodeSpi {
    EmailCode queryEmailCodeByEmailAndType(String email, Type type);
}
