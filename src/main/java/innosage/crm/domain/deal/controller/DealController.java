package innosage.crm.domain.deal.controller;

import innosage.crm.domain.deal.dto.DealRequestDto;
import innosage.crm.domain.deal.dto.DealResponseDto;
import innosage.crm.domain.deal.service.DealService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sheet/{sheetId}/deals")
@Tag(name = "deals")
public class DealController {

    private final DealService dealService;

    @PostMapping
    @Operation(summary = "거래 추가 ✔\uFE0F \uD83D\uDD11", description = "새로운 거래를 추가합니다.")
    public CommonResponse<DealResponseDto.addDeal> addDeal(
            @PathVariable Long sheetId,
            @RequestBody DealRequestDto.addDeal request) {
        return CommonResponse.onSuccess(dealService.addDeal(request));
    }

    @PutMapping("/{dealId}/company")
    @Operation(summary = "거래 회사 변경 ✔\uFE0F \uD83D\uDD11", description = "특정 거래의 회사를 변경합니다.")
    public CommonResponse changeCompany(
            @PathVariable Long sheetId,
            @PathVariable Long dealId,
            @RequestBody DealRequestDto.changeCompany request) {
        dealService.changeCompany(dealId, request);
        return CommonResponse.onSuccess(null);
    }

    @GetMapping("/{dealId}")
    @Operation(summary = "거래 조회 ✔\uFE0F \uD83D\uDD11", description = "특정 거래를 조회합니다.")
    public CommonResponse<DealResponseDto.getDeal> getDeal(
            @PathVariable Long sheetId,
            @PathVariable Long dealId) {
        return CommonResponse.onSuccess(dealService.getDeal(dealId));
    }

    @DeleteMapping("/{dealId}")
    @Operation(summary = "거래 삭제 ✔\uFE0F \uD83D\uDD11", description = "특정 거래를 삭제합니다.")
    public CommonResponse deleteDeal(
            @PathVariable Long sheetId,
            @PathVariable Long dealId) {
        dealService.deleteDeal(dealId);
        return CommonResponse.onSuccess(null);
    }
}
