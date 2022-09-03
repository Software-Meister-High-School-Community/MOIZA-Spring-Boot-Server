package com.moiza.moizaspringbootserver.global;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
public abstract class BaseTimeEntity extends BaseUUIDEntity {

    @NotNull
    private final ZonedDateTime createdAt = ZonedDateTime.now();
}
