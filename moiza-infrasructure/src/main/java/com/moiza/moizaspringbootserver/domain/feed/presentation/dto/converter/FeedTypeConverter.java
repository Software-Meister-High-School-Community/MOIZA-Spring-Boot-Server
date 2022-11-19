package com.moiza.moizaspringbootserver.domain.feed.presentation.dto.converter;

import com.moiza.moizaspringbootserver.feed.exception.BadFeedTypeException;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import org.springframework.core.convert.converter.Converter;

public class FeedTypeConverter implements Converter<String, FeedType> {
    @Override
    public FeedType convert(String source) {
        try {
            return FeedType.valueOf(source);
        } catch (IllegalArgumentException exception) {
            throw BadFeedTypeException.EXCEPTION;
        }
    }
}
