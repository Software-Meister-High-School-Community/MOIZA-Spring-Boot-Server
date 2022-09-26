package com.moiza.moizaspringbootserver.domain.annotation.config;

import com.moiza.moizaspringbootserver.annotation.UseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"com.moiza.moizaspringbootserver"},
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        value = UseCase.class
                )
        }
)
public class AnnotationComponentScan {
}
