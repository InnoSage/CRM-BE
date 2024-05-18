package innosage.crm.domain.attribute.useroption.controller;

import innosage.crm.domain.attribute.useroption.dto.UserOptionRequestDto;
import innosage.crm.domain.attribute.useroption.dto.UserOptionResponseDto;
import innosage.crm.domain.attribute.useroption.service.UserOptionService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sheet/{sheetId}/attributes/{attributeId}/users")
@Tag(name = "user-options")
public class UserOptionController {

    private final UserOptionService userOptionService;

    @PostMapping
    @Operation(summary = "사용자 옵션 추가 ✔\uFE0F \uD83D\uDD11", description = "새로운 사용자 옵션을 추가합니다.")
    public CommonResponse<UserOptionResponseDto.addUserOption> addUserOption(
            @PathVariable Long sheetId,
            @PathVariable Long attributeId,
            @RequestBody UserOptionRequestDto.addUserOption request) {
        return CommonResponse.onSuccess(userOptionService.addUserOption(attributeId, request));
    }

    @PatchMapping("/{userOptionId}")
    @Operation(summary = "사용자 옵션 수정 ✔\uFE0F \uD83D\uDD11", description = "기존 사용자 옵션을 수정합니다.")
    public CommonResponse<UserOptionResponseDto.updateUserOption> updateUserOption(
            @PathVariable Long sheetId,
            @PathVariable Long attributeId,
            @PathVariable Long userOptionId,
            @RequestBody UserOptionRequestDto.updateUserOption request) {
        return CommonResponse.onSuccess(userOptionService.updateUserOption(userOptionId, request));
    }

    @DeleteMapping("/{userOptionId}")
    @Operation(summary = "사용자 옵션 삭제 ✔\uFE0F \uD83D\uDD11", description = "기존 사용자 옵션을 삭제합니다.")
    public CommonResponse deleteUserOption(
            @PathVariable Long sheetId,
            @PathVariable Long attributeId,
            @PathVariable Long userOptionId) {
        userOptionService.deleteUserOption(userOptionId);
        return CommonResponse.onSuccess(null);
    }
}
