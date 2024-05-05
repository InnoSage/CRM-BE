package innosage.crm.sheet.mapper;

import innosage.crm.attribute.Attribute;
import innosage.crm.attribute.dto.AttributeResponseDto;
import innosage.crm.content.dto.ContentResponseDto;
import innosage.crm.deal.dto.DealResponseDto;
import innosage.crm.sheet.Sheet;
import innosage.crm.sheet.dto.SheetResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SheetMapper {

    public static Sheet toSheet(String name, String description) {
        return Sheet.builder()
                .name(name)
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
