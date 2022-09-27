package com.moiza.moizaspringbootserver.global.security;

import com.moiza.moizaspringbootserver.global.filter.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final UserJwtProvider jwtProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin().disable()
                .csrf().disable()
                .cors()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                // auth
                .antMatchers(HttpMethod.HEAD, "/auth/id-validations").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/tokens").permitAll()
                .antMatchers(HttpMethod.GET, "/auth/**").permitAll()

                //user
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.DELETE, "/users").authenticated()

                // Deny other requests
                .anyRequest().denyAll()

                // Add security filter
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
