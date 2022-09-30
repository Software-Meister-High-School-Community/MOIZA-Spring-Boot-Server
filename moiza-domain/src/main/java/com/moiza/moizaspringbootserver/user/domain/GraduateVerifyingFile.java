package com.moiza.moizaspringbootserver.user.domain;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@Aggregate
public class GraduateVerifyingFile {

    private final UUID userId;
    private final String verifyingFileUrl;
}
