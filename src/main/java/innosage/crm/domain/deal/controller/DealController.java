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
@RequestMapping("sheet/{sheetId}/deals")
@Tag(name = "deals")
public class DealController {

    private final DealService dealService;

    @PostMapping
    @Operation(summary = "거래 추가", description = "새로운 거래를 추가합니다.")
    public CommonResponse<DealResponseDto.addDeal> addDeal(
            @PathVariable Long sheetId,
            @RequestBody DealRequestDto.addDeal request) {
        return CommonResponse.onSuccess(dealService.addDeal(request));
    }
}
