package innosage.crm.domain.sheet.controller;

import innosage.crm.domain.sheet.service.SheetService;
import innosage.crm.global.common.CommonResponse;
import innosage.crm.domain.sheet.dto.SheetResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations/{organizationId}/sheet")
@Tag(name = "sheet")
public class SheetController {

    private final SheetService sheetService;

    @GetMapping
    @Operation(summary = "시트 목록 조회 ✔\uFE0F \uD83D\uDD11", description = "시트 목록을 조회합니다.")
    public CommonResponse<SheetResponseDto.getSheets> getSheetList(
            @PathVariable Long organizationId
    ) {
        return CommonResponse.onSuccess(sheetService.getSheets(organizationId));
    }

    @GetMapping("/{sheetId}")
    @Operation(summary = "시트 조회 ✔\uFE0F \uD83D\uDD11", description = "시트를 조회합니다.")
    public CommonResponse<SheetResponseDto.getSheetDetails> getSheet(
            @PathVariable Long organizationId,
            @PathVariable Long sheetId) {
        return CommonResponse.onSuccess(sheetService.getSheet(sheetId));
    }
}