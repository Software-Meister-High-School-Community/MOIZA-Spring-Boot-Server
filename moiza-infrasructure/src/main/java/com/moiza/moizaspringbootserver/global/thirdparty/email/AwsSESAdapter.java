package com.moiza.moizaspringbootserver.global.thirdparty.email;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.model.*;
import com.moiza.moizaspringbootserver.auth.spi.SendEmailSpi;
import com.moiza.moizaspringbootserver.domain.annotation.Adapter;
import com.moiza.moizaspringbootserver.global.property.AwsSESProperties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class AwsSESAdapter implements SendEmailSpi {

    private final AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync;
    private final AwsSESProperties awsSESProperties;

    @Override
    public void sendEmail(String email, String authCode) {
        Message message = new Message()
                .withSubject(createContent("MOIZA_EMAIL"))
                .withBody(new Body()
                        .withHtml(createContent(authCode)));

        SendEmailRequest request = new SendEmailRequest()
                .withDestination(new Destination().withToAddresses(email))
                .withSource(awsSESProperties.getSesSource())
                .withMessage(message);

        amazonSimpleEmailServiceAsync.sendEmailAsync(request);
    }

    private Content createContent(String text) {
        return new Content()
                .withCharset("UTF-8")
                .withData(text);
    }
}
