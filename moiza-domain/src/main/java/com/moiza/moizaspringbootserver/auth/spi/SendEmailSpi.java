package com.moiza.moizaspringbootserver.auth.spi;

public interface SendEmailSpi {
    void sendEmail(String email, String authCode);
}
