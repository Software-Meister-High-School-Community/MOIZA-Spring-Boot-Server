package com.moiza.moizaspringbootserver.global.entity;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseTimeEntity extends BaseUUIDEntity {

    @NotNull
    @CreatedDate
    private final LocalDateTime createdAt = LocalDateTime.now();
}
