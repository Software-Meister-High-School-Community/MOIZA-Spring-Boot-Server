package com.moiza.moizaspringbootserver.user.api.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class DomainUserEditRequest {
    private final String profileImageUrl;
    private final String profileBackgroundColor;
    private final String introduce;
    private final List<String> introduceLinkUrl;
}
