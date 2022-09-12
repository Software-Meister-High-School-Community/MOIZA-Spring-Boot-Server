package com.moiza.moizaspringbootserver.global.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseTimeEntity extends BaseUUIDEntity {

    @NotNull
    private final ZonedDateTime createdAt = ZonedDateTime.now();
}
