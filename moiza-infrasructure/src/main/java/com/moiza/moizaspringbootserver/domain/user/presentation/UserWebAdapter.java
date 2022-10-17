package com.moiza.moizaspringbootserver.domain.user.presentation;

import com.moiza.moizaspringbootserver.domain.user.presentation.dto.request.WebGraduateVerificationRequest;
import com.moiza.moizaspringbootserver.domain.user.presentation.dto.request.WebUserEditRequest;
import com.moiza.moizaspringbootserver.domain.user.presentation.dto.request.WebUserSignUpRequest;
import com.moiza.moizaspringbootserver.user.api.*;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainGraduateVerificationRequest;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserEditRequest;
import com.moiza.moizaspringbootserver.user.api.dto.request.DomainUserSignUpRequest;
import com.moiza.moizaspringbootserver.user.api.dto.response.MyPageResponse;
import com.moiza.moizaspringbootserver.user.api.dto.response.SearchAllUsersResponse;
import com.moiza.moizaspringbootserver.user.api.dto.response.UserProfileDetailsResponse;
import com.moiza.moizaspringbootserver.user.api.dto.response.UserSearchHistoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserWebAdapter {

	private final UserSignUpApi userSignUpApi;
	private final QueryUserProfileDetailApi queryUserProfileDetailApi;
	private final SearchAllUsersApi searchAllUserApi;
	private final UserSearchHistoryApi userSearchHistoryApi;
	private final UserSearchHistoryDeleteApi userSearchHistoryDeleteApi;
	private final UserDeleteApi userDeleteApi;
	private final GraduateVerificationApi graduateVerificationApi;
	private final QueryUserMyPageApi queryUserMyPageApi;
	private final UserEditApi userEditApi;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void userSignUp(@RequestBody @Valid WebUserSignUpRequest request) {
		userSignUpApi.execute(
			DomainUserSignUpRequest.builder()
				.accountId(request.getAccountId())
				.password(request.getPassword())
				.email(request.getEmail())
				.name(request.getName())
				.birthDay(request.getBirthday())
				.sex(request.getSex())
				.userType(request.getUserType())
				.school(request.getSchool())
				.build()
		);
	}

	@GetMapping
	public UserProfileDetailsResponse profileDetails(@PathVariable("user-id") UUID userId) {
		return queryUserProfileDetailApi.execute(userId);
	}
  
	@GetMapping("/searching")
	public SearchAllUsersResponse searchAllUsers(
			@RequestParam String name,
			@RequestParam Integer page
	) {
		return searchAllUserApi.execute(name, page);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/searching/history/{history-id}")
	public void deleteUserSearchHistory(@PathVariable("history-id") UUID historyId) {
		userSearchHistoryDeleteApi.execute(historyId);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping
	public void deleteUser() {
		userDeleteApi.execute();
	}

	@GetMapping("/searching/history")
	public UserSearchHistoryResponse userSearchHistory() {
		return userSearchHistoryApi.execute();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/graduate-verifications")
	public void graduateVerification(@RequestBody @Valid WebGraduateVerificationRequest request) {
		graduateVerificationApi.execute(
				new DomainGraduateVerificationRequest(request.getVerifyingFileUrl())
		);
	}

	@GetMapping
	public MyPageResponse getMyPage() {
		return queryUserMyPageApi.execute();
  	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PatchMapping
	public void editUserInfo(@RequestBody @Valid WebUserEditRequest request) {
		userEditApi.execute(
				DomainUserEditRequest.builder()
						.introduce(request.getIntroduce())
						.introduceLinkUrl(request.getIntroduceLinkUrl())
						.profileImageUrl(request.getProfileImageUrl())
						.profileBackgroundColor(request.getProfileBackgroundColor())
						.build()
		);
	}
}
