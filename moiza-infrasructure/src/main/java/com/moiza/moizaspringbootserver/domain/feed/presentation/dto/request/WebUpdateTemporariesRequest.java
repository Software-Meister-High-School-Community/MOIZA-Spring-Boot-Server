package com.moiza.moizaspringbootserver.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class WebUpdateTemporariesRequest {

    @NotBlank
    private String title;

    private String content;
}
