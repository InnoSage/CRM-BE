package innosage.crm.auth.organization.controller;

import innosage.crm.auth.organization.dto.OrganizationRequestDto;
import innosage.crm.auth.organization.dto.OrganizationResponseDto;
import innosage.crm.auth.organization.service.OrganizationService;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
@Tag(name = "organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    @Operation(summary = "조직 추가 ✔\uFE0F \uD83D\uDD11", description = "조직을 추가합니다. ")
    public CommonResponse<OrganizationResponseDto.addOrganization> addOrganization(
            @RequestBody OrganizationRequestDto.addOrganization request
            ) {
        return CommonResponse.onSuccess(organizationService.addOrganization(request));
    }

    @GetMapping
    @Operation(summary = "조직 조회 ✔\uFE0F \uD83D\uDD11", description = "조직을 조회합니다.")
    public CommonResponse<List<OrganizationResponseDto.getOrganization>> getOrganizations() {

        return CommonResponse.onSuccess(organizationService.getOrganizations());
    }

    @PatchMapping("/{organizationId}/members")
    @Operation(summary = "조직 멤버 관리 ✔\uFE0F \uD83D\uDD11", description = "조직의 멤버를 관리합니다.")
    public CommonResponse<OrganizationResponseDto.updateMember> manageOrganization(
            @PathVariable Long organizationId,
            @RequestBody OrganizationRequestDto.updateMember request
    ) {
        return CommonResponse.onSuccess(organizationService.updateMember(organizationId, request));
    }
}
