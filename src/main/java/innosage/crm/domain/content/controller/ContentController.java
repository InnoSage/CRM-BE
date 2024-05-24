package innosage.crm.domain.content.controller;

import innosage.crm.domain.content.dto.ContentRequestDto;
import innosage.crm.domain.content.dto.ContentResponseDto;
import innosage.crm.domain.content.service.ContentService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
@Tag(name = "contents")
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/sheet/{sheetId}/deals/{dealId}/contents")
    @Operation(summary = "속성값 추가 ✔\uFE0F \uD83D\uDD11", description = "새로운 속성값을 추가합니다.")
    public CommonResponse<ContentResponseDto.addContent> addContent(
            @PathVariable Long sheetId,
            @PathVariable Long dealId,
            @RequestBody ContentRequestDto.addContent request) {
        return CommonResponse.onSuccess(contentService.addContent(dealId, request));
    }

    @PatchMapping("/sheet/{sheetId}/deals/{dealId}/contents/{contentId}")
    @Operation(summary = "속성값 변경 ✔\uFE0F \uD83D\uDD11", description = "특정 속성값을 변경합니다.")
    public CommonResponse<ContentResponseDto.updateContent> updateContent(
            @PathVariable Long sheetId,
            @PathVariable Long dealId,
            @PathVariable Long contentId,
            @RequestBody ContentRequestDto.updateContent request) {
        return CommonResponse.onSuccess(contentService.updateContent(contentId, request));
    }
}
