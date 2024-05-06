package innosage.crm.domain.attribute.controller;

import innosage.crm.domain.attribute.dto.AttributeRequestDto;
import innosage.crm.domain.attribute.dto.AttributeResponseDto;
import innosage.crm.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sheet/{sheetId}/attributes")
public class AttributeController {

    @PostMapping
    @Operation(summary = "속성 추가", description = "새로운 속성을 추가합니다.")
    public CommonResponse<AttributeResponseDto.addAttribute> addAttribute(
            @PathVariable Long sheetId,
            @Valid @RequestBody AttributeRequestDto.addAttribute request) {
        return null;
    }

    @PatchMapping("/{attributeId}")
    @Operation(summary = "속성 수정", description = "기존 속성을 수정합니다.")
    public CommonResponse<AttributeResponseDto.updateAttribute> updateAttribute(
            @PathVariable Long sheetId,
            @PathVariable Long attributeId,
            @Valid @RequestBody AttributeRequestDto.updateAttribute request) {
        return null;
    }

    @DeleteMapping
    @Operation(summary = "속성 삭제", description = "기존 속성을 삭제합니다.")
    public CommonResponse deleteAttribute(
            @PathVariable Long sheetId,
            @PathVariable Long attributeId) {
        return null;
    }
}
