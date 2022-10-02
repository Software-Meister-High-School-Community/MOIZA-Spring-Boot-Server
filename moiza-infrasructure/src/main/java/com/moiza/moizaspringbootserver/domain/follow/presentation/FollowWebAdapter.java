package com.moiza.moizaspringbootserver.domain.follow.presentation;

import com.moiza.moizaspringbootserver.follow.api.CancelFollowApi;
import com.moiza.moizaspringbootserver.follow.api.FollowUserApi;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/follow")
@RestController
public class FollowWebAdapter {

	private final FollowUserApi followUserApi;
	private final CancelFollowApi cancelFollowApi;

	@PostMapping("/{user-id}")
	public void followUser(@PathVariable("user-id") UUID userId)  {
		followUserApi.execute(userId);
	}

	@DeleteMapping("/{user-id}")
	public void cancelFollow(@PathVariable("user-id") UUID userId) {
		cancelFollowApi.execute(userId);
	}
}
