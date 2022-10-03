package com.moiza.moizaspringbootserver.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@NoArgsConstructor
public class WebUserEditRequest {
    @NotNull
    @Pattern(regexp = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)", message = "URL 형식을 준수해야 합니다")
    private String profileImageUrl;

    @NotNull
    @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", message = "올바르지 않은 hex 색상값입니다")
    @Size(min = 7, max = 7, message = "프로필 색상은 #을 포함한 hex 형식으로 입력되어야 합니다")
    private String profileBackgroundColor;

    @NotNull
    private String introduce;

    @NotNull
    @Pattern(regexp = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)", message = "URL 형식을 준수해야 합니다")
    private List<String> introduceLinkUrl;
}
