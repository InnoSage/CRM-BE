package innosage.crm.domain.sheet.mapper;

import innosage.crm.auth.organization.Organization;
import innosage.crm.domain.attribute.dto.AttributeResponseDto;
import innosage.crm.domain.company.Company;
import innosage.crm.domain.company.mapper.CompanyMapper;
import innosage.crm.domain.deal.dto.DealResponseDto;
import innosage.crm.domain.filter.mapper.FilterMapper;
import innosage.crm.domain.sheet.Sheet;
import innosage.crm.domain.sheet.dto.SheetResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SheetMapper {

    public static Sheet toSheet(String name, Organization organization) {
        return Sheet.builder()
                .name(name)
                .organization(organization)
                .build();
    }

    public static SheetResponseDto.addSheet toAddSheet(Sheet sheet) {
        return SheetResponseDto.addSheet.builder()
                .sheetId(sheet.getId())
                .build();
    }

    public static SheetResponseDto.getSheet toGetSheet(Sheet sheet) {
        return SheetResponseDto.getSheet.builder()
                .sheetId(sheet.getId())
                .sheetName(sheet.getName())
                .build();
    }

    public static SheetResponseDto.getSheets toGetSheetList(List<Sheet> sheets) {
        return SheetResponseDto.getSheets.builder()
                .sheets(sheets.stream()
                    .map(SheetMapper::toGetSheet)
                    .collect(Collectors.toList())
                )
                .build();
    }

    public static SheetResponseDto.getSheetDetails toGetSheetDetails(Sheet sheet, List<AttributeResponseDto.getAttribute> attributes, List<DealResponseDto.getDeal> deals, List<Company> companies) {
        return SheetResponseDto.getSheetDetails.builder()
                .sheetId(sheet.getId())
                .sheetName(sheet.getName())
                .companies(CompanyMapper.toGetCompanyList(companies))
                .attributes(attributes)
                .filters(sheet.getFilters().stream()
                        .map(FilterMapper::toGetFilter)
                        .collect(Collectors.toList())
                        )
                .deals(deals)
                .build();
    }
}
