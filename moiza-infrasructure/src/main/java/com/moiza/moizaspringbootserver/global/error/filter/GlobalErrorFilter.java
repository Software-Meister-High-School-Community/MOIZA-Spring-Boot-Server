package com.moiza.moizaspringbootserver.global.error.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moiza.moizaspringbootserver.error.ErrorProperty;
import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.global.error.ErrorResponse;
import com.moiza.moizaspringbootserver.global.error.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class GlobalErrorFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (MoizaException e) {
            setErrorResponse(e.getErrorProperty(), response);
        } catch (Exception e) {
            if (e.getCause() instanceof MoizaException) {
                setErrorResponse(((MoizaException) e.getCause()).getErrorProperty(), response);
            } else {
                setErrorResponse(GlobalErrorCode.INTERNAL_SERVER_ERROR, response);
            }
        }
    }

    private void setErrorResponse(ErrorProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new ErrorResponse(errorProperty)
                )
        );
    }
}
