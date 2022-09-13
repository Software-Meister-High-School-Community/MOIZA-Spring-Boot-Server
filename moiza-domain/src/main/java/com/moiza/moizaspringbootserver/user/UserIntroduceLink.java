package com.moiza.moizaspringbootserver.user;

import com.moiza.moizaspringbootserver.annotation.Aggregate;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Aggregate
@Getter
@Builder
public class UserIntroduceLink {

	private final UUID id;
	private final String linkUrl;
	private final UUID userId;
}
