package com.moiza.moizaspringbootserver.user.exception;

import com.moiza.moizaspringbootserver.error.MoizaException;
import com.moiza.moizaspringbootserver.user.error.SearchHistoryErrorCode;

public class HistoryPermissionDeniedException extends MoizaException {
    private HistoryPermissionDeniedException() {
        super(SearchHistoryErrorCode.SEARCH_HISTORY_DELETE_DENIED);
    }

    public static final MoizaException EXCEPTION = new HistoryPermissionDeniedException();
}
