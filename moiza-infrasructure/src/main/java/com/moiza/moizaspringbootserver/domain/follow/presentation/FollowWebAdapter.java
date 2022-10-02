package com.moiza.moizaspringbootserver.domain.follow.presentation;

import com.moiza.moizaspringbootserver.follow.api.CancelFollowApi;
import com.moiza.moizaspringbootserver.follow.api.DeleteFollowApi;
import com.moiza.moizaspringbootserver.follow.api.FollowUserApi;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FollowWebAdapter {

	private final FollowUserApi followUserApi;
	private final CancelFollowApi cancelFollowApi;
	private final DeleteFollowApi deleteFollowApi;

	@PostMapping("/follow/{user-id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void followUser(@PathVariable("user-id") UUID userId)  {
		followUserApi.execute(userId);
	}

	@DeleteMapping("/follow/{user-id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cancelFollow(@PathVariable("user-id") UUID userId) {
		cancelFollowApi.execute(userId);
	}

	@DeleteMapping("/{user-id}/follow")
	public void deleteFollow(@PathVariable("user-id") UUID userId) {
		deleteFollowApi.execute(userId);
	}
}
