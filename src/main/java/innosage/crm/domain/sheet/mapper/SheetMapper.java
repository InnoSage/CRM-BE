package innosage.crm.domain.sheet.mapper;

import innosage.crm.domain.attribute.dto.AttributeResponseDto;
import innosage.crm.domain.deal.dto.DealResponseDto;
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

    public static Sheet toSheet(String name, String description) {
        return Sheet.builder()
                .name(name)
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

    public static SheetResponseDto.getSheetDetails toGetSheetDetails(Sheet sheet, List<AttributeResponseDto.getAttribute> attributes, List<DealResponseDto.getDeal> deals) {
        return SheetResponseDto.getSheetDetails.builder()
                .sheetId(sheet.getId())
                .sheetName(sheet.getName())
                .attributes(attributes)
                .deals(deals)
                .build();
    }
}
