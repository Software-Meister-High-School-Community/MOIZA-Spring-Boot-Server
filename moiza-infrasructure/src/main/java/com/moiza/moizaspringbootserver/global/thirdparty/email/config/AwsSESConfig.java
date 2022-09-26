package com.moiza.moizaspringbootserver.global.thirdparty.email.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient;
import com.moiza.moizaspringbootserver.global.property.AwsSESProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class AwsSESConfig {

    private final AwsSESProperties awsSesProperties;

    @Bean
    public AmazonSimpleEmailServiceAsync amazonSimpleEmailService() {
        final BasicAWSCredentials credentials = new BasicAWSCredentials(
                awsSesProperties.getAccessKey(),
                awsSesProperties.getSecretKey()
        );

        return AmazonSimpleEmailServiceAsyncClient.asyncBuilder()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(awsSesProperties.getRegion())
                .build();
    }
}
