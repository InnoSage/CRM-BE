package innosage.crm.domain.deal.controller;

import innosage.crm.domain.deal.dto.DealRequestDto;
import innosage.crm.domain.deal.dto.DealResponseDto;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("sheet/{sheetId}/deals")
@Tag(name = "deals")
public class DealController {

    @PostMapping
    @Operation(summary = "거래 추가", description = "새로운 거래를 추가합니다.")
    public CommonResponse<DealResponseDto.addDeal> addDeal(
            Long sheetId,
            @RequestBody DealRequestDto.addDeal request) {
        return null;
    }
}
