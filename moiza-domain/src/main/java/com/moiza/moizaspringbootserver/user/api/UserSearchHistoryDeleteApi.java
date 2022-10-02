package com.moiza.moizaspringbootserver.user.api;

import java.util.UUID;

public interface UserSearchHistoryDeleteApi {
    void execute(UUID historyId);
}
