package innosage.crm.domain.content.controller;

import innosage.crm.domain.content.dto.ContentRequestDto;
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
    public CommonResponse addContent(
            @PathVariable Long sheetId,
            @PathVariable Long dealId,
            @RequestBody ContentRequestDto.addContent request) {
        contentService.addContent(dealId, request);
        return CommonResponse.onSuccess(null);
    }
}
