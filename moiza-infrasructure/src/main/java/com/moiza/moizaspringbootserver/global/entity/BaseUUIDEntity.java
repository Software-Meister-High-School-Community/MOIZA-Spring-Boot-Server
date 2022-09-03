package com.moiza.moizaspringbootserver.global.entity;

import com.fasterxml.uuid.Generators;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseUUIDEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @NotNull
    private final UUID id = Generators.timeBasedGenerator().generate();
}
