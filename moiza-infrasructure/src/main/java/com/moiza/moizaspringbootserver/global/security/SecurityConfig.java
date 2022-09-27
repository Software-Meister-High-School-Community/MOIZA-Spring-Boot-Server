package com.moiza.moizaspringbootserver.global.security;

import com.moiza.moizaspringbootserver.global.filter.JwtTokenFilter;
import com.moiza.moizaspringbootserver.user.domain.enums.UserType;
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
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                // user
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.DELETE, "/users").authenticated()
                .antMatchers(HttpMethod.GET, "/users").authenticated()
                .antMatchers(HttpMethod.GET, "/users/{user-id}").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users").authenticated()
                .antMatchers(HttpMethod.POST, "/users/graduate-verifications").hasAuthority(UserType.ROLE_USER.name())
                .antMatchers(HttpMethod.GET, "/users/searching").authenticated()
                .antMatchers(HttpMethod.POST, "/users/{user-id}/reports").authenticated()
                .antMatchers(HttpMethod.GET, "/users/searching/history").authenticated()
                .antMatchers(HttpMethod.DELETE, "/users/searching/history/{history-id}").authenticated()

                // auth
                .antMatchers(HttpMethod.POST,"/auth/tokens").permitAll()
                .antMatchers(HttpMethod.PUT, "/auth/tokens").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/email-verifications").permitAll()
                .antMatchers(HttpMethod.HEAD, "/auth/email-verifications").permitAll()
                .antMatchers(HttpMethod.HEAD, "/auth/id-validations").permitAll()
                .antMatchers(HttpMethod.GET,  "/auth/{user-email}").permitAll()
                .antMatchers(HttpMethod.PATCH, "/auth/password").permitAll()

                // follow
                .antMatchers(HttpMethod.GET, "/following/{user-id}").authenticated()
                .antMatchers(HttpMethod.GET, "/follower/{user-id}").authenticated()
                .antMatchers(HttpMethod.POST, "/follow/{user-id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/{user-id}/following").authenticated()
                .antMatchers(HttpMethod.DELETE, "/{user-id}/follower").authenticated()

                // feeds
                .antMatchers(HttpMethod.GET, "/feeds/{feed-id}").permitAll()
                .antMatchers(HttpMethod.POST, "/feeds").authenticated()
                .antMatchers(HttpMethod.PATCH, "/feeds/{feed-id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/feeds/{feed-id}").authenticated()
                .antMatchers(HttpMethod.POST, "/feeds/temporaries").authenticated()
                .antMatchers(HttpMethod.GET, "/feeds/temporaries/{feed-id}").authenticated()
                .antMatchers(HttpMethod.PATCH, "/feeds/temporaries/{feed-id}").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.DELETE, "/feeds/temporaries/{feed-id}").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.POST, "/feeds/{feed-id}/reports").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.POST, "/feeds/{feed-id}/like").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.DELETE, "/feeds/{feed-id}/like").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.DELETE, "/feeds/temporaries/{feed-id}").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.PATCH, "/feeds/temporaries/{feed-id}").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.GET, "/feeds/searching").permitAll()
                .antMatchers(HttpMethod.GET, "/feeds/lists/{user-id}").permitAll()
                .antMatchers(HttpMethod.GET, "/feeds/lists").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name(), UserType.ROLE_USER.name())
                .antMatchers(HttpMethod.GET, "/feeds/lists/temporaries").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name(), UserType.ROLE_USER.name())
                .antMatchers(HttpMethod.GET, "/feeds/lists/populars").permitAll()
                .antMatchers(HttpMethod.GET, "/feeds/suggestions").permitAll()

                // comments
                .antMatchers(HttpMethod.POST, "/comments").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.POST, "/comments/{comment-id}").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.DELETE, "/comments/{comment-id}").authenticated()
                .antMatchers(HttpMethod.PATCH, "/comments/{comment-id}").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.POST, "/comments/{reports").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.PATCH, "/comments/{comment-id}/pin").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())
                .antMatchers(HttpMethod.PATCH, "/comments/{comment-id}/pin/cancel").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())


                // notice
                .antMatchers(HttpMethod.GET, "/notices/{notice-id}").authenticated()
                .antMatchers(HttpMethod.POST, "/notices").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.PATCH, "/notices/{notice-id}").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/notices/{notice-id}").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.GET, "/notices/lists").permitAll()

                // notification
                .antMatchers(HttpMethod.GET, "/notifications/lists").authenticated()
                .antMatchers(HttpMethod.PATCH, "/notifications/subscribing").authenticated()
                .antMatchers(HttpMethod.PATCH, "/notifications/unsubscribing").authenticated()

                // admins
                .antMatchers(HttpMethod.GET, "/admins/reports/users").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.GET, "/admins/reports/feeds").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.GET, "/admins/reports/comments").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.POST, "/admins/{user-id}/suspensions").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/admins/{user-id}").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.PATCH, "/admins/graduate/{user-id}/acceptances").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.PATCH, "/admins/graduate/{user-Id}/rejections").hasAnyAuthority(UserType.ROLE_ADMIN.name())
                .antMatchers(HttpMethod.GET, "/admins/graduate/lists").hasAnyAuthority(UserType.ROLE_ADMIN.name())

                // images
                .antMatchers(HttpMethod.POST, "/images").authenticated()

                .anyRequest().denyAll()

                .and()
                .addFilterBefore(new JwtTokenFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
