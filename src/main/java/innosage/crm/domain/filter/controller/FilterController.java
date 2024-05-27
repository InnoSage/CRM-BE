package innosage.crm.domain.filter.controller;

import innosage.crm.domain.filter.dto.FilterRequestDto;
import innosage.crm.domain.filter.dto.FilterResponseDto;
import innosage.crm.domain.filter.service.FilterService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("sheet/{sheetId}")
@Tag(name = "filters")
public class FilterController {

    private final FilterService filterService;

    @PostMapping("/filter")
    @Operation(summary = "필터 추가 ✔\uFE0F \uD83D\uDD11", description = "새로운 필터를 추가합니다.")
    public CommonResponse<FilterResponseDto.addFilter> addFilter(
            @PathVariable Long sheetId,
            @RequestBody FilterRequestDto.addFilter request) {
        return CommonResponse.onSuccess(filterService.addFilter(sheetId, request));
    }

    @DeleteMapping("/filter/{filterId}")
    @Operation(summary = "필터 삭제 ✔\uFE0F \uD83D\uDD11", description = "필터를 삭제합니다.")
    public CommonResponse deleteFilter(
            @PathVariable Long sheetId,
            @PathVariable Long filterId) {
        filterService.deleteFilter(filterId);
        return CommonResponse.onSuccess(null);
    }

}
