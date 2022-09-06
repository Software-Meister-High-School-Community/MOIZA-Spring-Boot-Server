package com.moiza.moizaspringbootserver.global.entity;

import com.fasterxml.uuid.Generators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseUUIDEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @NotNull
    private UUID id = Generators.timeBasedGenerator().generate();
}
