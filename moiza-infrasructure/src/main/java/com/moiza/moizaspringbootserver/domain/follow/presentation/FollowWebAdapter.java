package com.moiza.moizaspringbootserver.domain.follow.presentation;

import com.moiza.moizaspringbootserver.follow.api.FollowUserApi;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/follow")
@RestController
public class FollowWebAdapter {

	private final FollowUserApi followUserApi;

	@PostMapping("/{user-id}")
	public void followUser(@PathVariable("user-id") UUID userId)  {
		followUserApi.execute(userId);
	}
}
