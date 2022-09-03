package com.moiza.moizaspringbootserver.global;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
public abstract class BaseTimeEntity extends BaseUUIDEntity {

    @Column(nullable = false)
    private final ZonedDateTime createdAt = ZonedDateTime.now();
}
