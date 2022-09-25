package com.moiza.moizaspringbootserver.user.domain;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@Aggregate
public class UserSuspension {

    private LocalDateTime expiredAt;
    private UUID userId;

}
