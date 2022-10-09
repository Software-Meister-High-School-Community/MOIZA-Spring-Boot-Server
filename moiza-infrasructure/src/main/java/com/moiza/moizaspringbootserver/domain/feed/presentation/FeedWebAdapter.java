package com.moiza.moizaspringbootserver.domain.feed.presentation;

import com.moiza.moizaspringbootserver.feed.api.PublishedFeedListApi;
import com.moiza.moizaspringbootserver.feed.api.dto.response.PublishedFeedListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedWebAdapter {
    private final PublishedFeedListApi publishedFeedListApi;

    @GetMapping("/list/{user-id}")
    public PublishedFeedListResponse getFeeds(@PathVariable(value = "user-id", required = false) String userId,
                                              @RequestParam("category") String category,
                                              @RequestParam("type") String type,
                                              @RequestParam("order") String order,
                                              @RequestParam("page") int page) {
        return publishedFeedListApi.execute(userId.isEmpty() ? null : UUID.fromString(userId), category,
                type, order, page);
    }
}
