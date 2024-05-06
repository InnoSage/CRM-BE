package innosage.crm.sheet.controller;

import innosage.crm.global.common.CommonResponse;
import innosage.crm.sheet.dto.SheetResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sheet")
public class SheetController {

    @GetMapping
    @Operation(summary = "시트 목록 조회", description = "시트 목록을 조회합니다.")
    public CommonResponse<SheetResponseDto.getSheets> getSheetList() {
        return null;
    }

    @GetMapping("/{sheetId}")
    @Operation(summary = "시트 조회", description = "시트를 조회합니다.")
    public CommonResponse<SheetResponseDto.getSheetDetails> getSheet(
            Long sheetId) {
        return null;
    }
}