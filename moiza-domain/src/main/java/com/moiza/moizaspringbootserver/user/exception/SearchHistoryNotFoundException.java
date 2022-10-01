package com.moiza.moizaspringbootserver.user.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.user.error.SearchHistoryErrorCode;

public class SearchHistoryNotFoundException extends MoizaException {

    private SearchHistoryNotFoundException() {
        super(SearchHistoryErrorCode.SEARCH_HISTORY_NOT_FOUND);
    }

    public static final MoizaException EXCEPTION = new SearchHistoryNotFoundException();
}
