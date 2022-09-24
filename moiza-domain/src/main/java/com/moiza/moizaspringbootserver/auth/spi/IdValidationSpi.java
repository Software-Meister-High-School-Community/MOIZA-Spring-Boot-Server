package com.moiza.moizaspringbootserver.auth.spi;

public interface IdValidationSpi {
    boolean isUserExists(String accountId);
}
