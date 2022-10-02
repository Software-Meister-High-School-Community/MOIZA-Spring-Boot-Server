package com.moiza.moizaspringbootserver.user.error;

import com.moiza.moizaspringbootserver.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SearchHistoryErrorCode implements ErrorProperty {

    SEARCH_HISTORY_DELETE_DENIED(403, "Permission Denied"),
    SEARCH_HISTORY_NOT_FOUND(404, "Search History Not Found")
    ;

    private final int status;
    private final String message;
}
