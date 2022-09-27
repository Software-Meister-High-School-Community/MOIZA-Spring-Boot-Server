package com.moiza.moizaspringbootserver.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moiza.moizaspringbootserver.global.error.filter.GlobalErrorFilter;
import com.moiza.moizaspringbootserver.global.filter.JwtTokenFilter;
import com.moiza.moizaspringbootserver.global.security.UserJwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final ObjectMapper objectMapper;
    private final UserJwtProvider userJwtProvider;

    @Override
    public void configure(HttpSecurity builder) {
        builder.addFilterBefore(new JwtTokenFilter(userJwtProvider), UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(new GlobalErrorFilter(objectMapper), JwtTokenFilter.class);
    }
}
