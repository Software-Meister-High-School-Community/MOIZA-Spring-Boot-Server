package com.moiza.moizaspringbootserver.domain.feed.presentation;

import com.moiza.moizaspringbootserver.domain.feed.presentation.dto.converter.FeedTypeConverter;
import com.querydsl.core.annotations.Config;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Config
public class FeedPresentationConfiguration implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new FeedTypeConverter());
    }
}
