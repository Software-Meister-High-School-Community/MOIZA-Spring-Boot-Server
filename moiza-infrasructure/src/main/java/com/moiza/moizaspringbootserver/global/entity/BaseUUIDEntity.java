package com.moiza.moizaspringbootserver.global;

import com.fasterxml.uuid.Generators;
import lombok.Getter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class BaseUUIDEntity {

    @NotNull
    private final UUID id = Generators.timeBasedGenerator().generate();
}
