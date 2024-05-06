package innosage.crm.domain.company.controller;

import innosage.crm.domain.company.dto.CompanyResponseDto;
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

    @PostMapping
    @Operation(summary = "회사 추가", description = "새로운 회사를 추가합니다.")
    public CommonResponse<CompanyResponseDto.addCompany> addCompany(
            Long sheetId) {
        return null;
    }

    @GetMapping
    @Operation(summary = "회사 조회", description = "회사를 조회합니다.")
    public CommonResponse<CompanyResponseDto.getCompanyList> getCompany(
            Long sheetId) {
        return null;
    }

    @DeleteMapping("/{companyId}")
    @Operation(summary = "회사 삭제", description = "회사를 삭제합니다.")
    public CommonResponse deleteCompany(
            Long sheetId,
            Long companyId) {
        return null;
    }
}
