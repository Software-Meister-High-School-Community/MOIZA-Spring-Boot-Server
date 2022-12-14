package com.moiza.moizaspringbootserver.global.security;

import com.moiza.moizaspringbootserver.domain.auth.domain.RefreshTokenEntity;
import com.moiza.moizaspringbootserver.domain.auth.domain.repository.RefreshTokenRepository;
import com.moiza.moizaspringbootserver.global.exception.InvalidTokenException;
import com.moiza.moizaspringbootserver.global.security.auth.AuthDetailService;
import com.moiza.moizaspringbootserver.global.security.properties.JwtProperties;
import com.moiza.moizaspringbootserver.user.spi.UserJwtSpi;
import com.moiza.moizaspringbootserver.user.spi.dto.response.SpiTokenResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserJwtProvider implements UserJwtSpi {

    public static final String ACCESS_KEY = "access";
    public static final String REFRESH_KEY = "refresh";

    private final JwtProperties jwtProperties;
    private final AuthDetailService authDetailService;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public SpiTokenResponse getToken(String email) {
        return SpiTokenResponse.builder()
                .accessToken(generateAccessToken(email))
                .refreshExp(jwtProperties.getRefreshExp())
                .refreshToken(generateRefreshToken(email))
                .build();
    }

    public String generateAccessToken(String email) {
        return generateToken(email, ACCESS_KEY, jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String email) {
        String refreshToken = generateToken(email, REFRESH_KEY, jwtProperties.getRefreshExp());
        refreshTokenRepository.save(RefreshTokenEntity.builder()
                .email(email)
                .refreshToken(refreshToken)
                .build());
        return refreshToken;
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())) {
            return bearerToken.replace(jwtProperties.getPrefix(), "");
        }
        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailService
                .loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String parseToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix()))
            return bearerToken.replace(jwtProperties.getPrefix(), "");
        return null;
    }

    private Claims getTokenBody(String token) {

        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    private String generateToken(String email, String type, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(email)
                .claim("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    public LocalDateTime getExpiredTime() {
        return LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp());
    }
}
