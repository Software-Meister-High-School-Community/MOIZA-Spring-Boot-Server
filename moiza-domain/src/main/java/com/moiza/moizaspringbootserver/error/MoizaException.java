package com.moiza.moizaspringbootserver.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class MoizaException extends RuntimeException {

	private final ErrorProperty errorProperty;
}
