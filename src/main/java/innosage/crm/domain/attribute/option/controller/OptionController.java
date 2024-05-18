package innosage.crm.domain.attribute.option.controller;

import innosage.crm.domain.attribute.option.dto.OptionRequestDto;
import innosage.crm.domain.attribute.option.dto.OptionResponseDto;
import innosage.crm.domain.attribute.option.service.OptionService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sheet/{sheetId}/attributes/{attributeId}/options")
@Tag(name = "options")
public class OptionController {

    private final OptionService optionService;

    @PostMapping
    @Operation(summary = "옵션 추가 ✔\uFE0F \uD83D\uDD11", description = "새로운 옵션을 추가합니다.")
    public CommonResponse<OptionResponseDto.addOption> addOption(
            @PathVariable Long sheetId,
            @PathVariable Long attributeId,
            @RequestBody OptionRequestDto.addOption request) {
        return CommonResponse.onSuccess(optionService.addOption(attributeId, request));
    }

    @PatchMapping("/{optionId}")
    @Operation(summary = "옵션 수정 ✔\uFE0F \uD83D\uDD11", description = "기존 옵션을 수정합니다.")
    public CommonResponse<OptionResponseDto.updateOption> updateOption(
            @PathVariable Long sheetId,
            @PathVariable Long attributeId,
            @PathVariable Long optionId,
            @RequestBody OptionRequestDto.updateOption request) {
        return CommonResponse.onSuccess(optionService.updateOption(optionId, request));
    }

    @DeleteMapping("/{optionId}")
    @Operation(summary = "옵션 삭제 ✔\uFE0F \uD83D\uDD11", description = "기존 옵션을 삭제합니다.")
    public CommonResponse deleteOption(
            @PathVariable Long sheetId,
            @PathVariable Long attributeId,
            @PathVariable Long optionId) {
        optionService.deleteOption(optionId);
        return CommonResponse.onSuccess(null);
    }
}
