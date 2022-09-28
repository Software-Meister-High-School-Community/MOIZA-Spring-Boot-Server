package com.moiza.moizaspringbootserver.user.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class UserSearchHistoryResponse {

    private final List<Keywords> keywords;

    @Builder
    public static final class Keywords {
        private final UUID historyId;
        private final String keyword;
    }
}
