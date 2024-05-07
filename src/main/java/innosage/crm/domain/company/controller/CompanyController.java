package innosage.crm.domain.company.controller;

import innosage.crm.domain.company.dto.CompanyRequestDto;
import innosage.crm.domain.company.dto.CompanyResponseDto;
import innosage.crm.domain.company.service.CompanyService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sheet/{sheetId}/company")
@Tag(name = "companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    @Operation(summary = "회사 추가 ✔\uFE0F \uD83D\uDD11", description = "새로운 회사를 추가합니다.")
    public CommonResponse<CompanyResponseDto.addCompany> addCompany(
            @PathVariable Long sheetId,
            @RequestBody CompanyRequestDto.addCompany request
    ) {
        return CommonResponse.onSuccess(companyService.addCompany(sheetId, request));
    }

    @GetMapping
    @Operation(summary = "회사 조회 ✔\uFE0F \uD83D\uDD11", description = "회사를 조회합니다.")
    public CommonResponse<CompanyResponseDto.getCompanyList> getCompany(
            @PathVariable Long sheetId
    ) {
        return CommonResponse.onSuccess(companyService.getCompanyList(sheetId));
    }

    @DeleteMapping("/{companyId}")
    @Operation(summary = "회사 삭제 ✔\uFE0F \uD83D\uDD11", description = "회사를 삭제합니다.")
    public CommonResponse deleteCompany(
            @PathVariable Long sheetId,
            @PathVariable Long companyId) {
        companyService.deleteCompany(sheetId, companyId);
        return CommonResponse.onSuccess(null);
    }
}
