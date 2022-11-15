package com.moiza.moizaspringbootserver.domain.feed.presentation.dto.request;

import com.moiza.moizaspringbootserver.feed.Category;
import com.moiza.moizaspringbootserver.feed.enums.FeedType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
public class WebCreateFeedRequest {

    @NotBlank
    private String title;

    private String content;

    @NotNull
    private FeedType feedType;

    @NotBlank
    private String category;

    private List<String> imageUrls;
}
