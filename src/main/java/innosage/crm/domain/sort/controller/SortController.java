package innosage.crm.domain.sort.controller;

import innosage.crm.domain.sort.dto.SortRequestDto;
import innosage.crm.domain.sort.dto.SortResponseDto;
import innosage.crm.domain.sort.service.SortService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("sheet/{sheetId}")
@Tag(name = "sorts")
public class SortController {

    private final SortService sortService;

    @PostMapping("/sort")
    @Operation(summary = "정렬 추가 ✔\uFE0F \uD83D\uDD11", description = "새로운 정렬을 추가합니다.")
    public CommonResponse<SortResponseDto.addSort> addSort(
            @PathVariable Long sheetId,
            @RequestBody SortRequestDto.addSort request) {
        return CommonResponse.onSuccess(sortService.addSort(sheetId, request));
    }
}
