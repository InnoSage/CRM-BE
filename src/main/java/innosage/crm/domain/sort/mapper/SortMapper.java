package innosage.crm.domain.sort.mapper;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.sheet.Sheet;
import innosage.crm.domain.sort.Sort;
import innosage.crm.domain.sort.SortType;
import innosage.crm.domain.sort.dto.SortResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SortMapper {

    public static Sort toSort(String sortType, Sheet sheet, Attribute attribute) {
        return Sort.builder()
                .sortType(SortType.valueOf(sortType))
                .sheet(sheet)
                .targetAttribute(attribute)
                .build();
    }

    public static SortResponseDto.addSort toAddSort(Sort sort) {
        return SortResponseDto.addSort.builder()
                .sortId(sort.getId())
                .build();
    }
}
