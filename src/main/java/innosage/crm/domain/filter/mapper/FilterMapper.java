package innosage.crm.domain.filter.mapper;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.filter.Filter;
import innosage.crm.domain.filter.FilterType;
import innosage.crm.domain.filter.dto.FilterResponseDto;
import innosage.crm.domain.sheet.Sheet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilterMapper {

    public static Filter toFilter(String keyword, String filterType, Sheet sheet, Attribute attribute) {
        return Filter.builder()
                .keyword(keyword)
                .filterType(FilterType.valueOf(filterType))
                .sheet(sheet)
                .targetAttribute(attribute)
                .build();
    }

    public static FilterResponseDto.addFilter toAddFilter(Filter filter) {
        return FilterResponseDto.addFilter.builder()
                .filterId(filter.getId())
                .build();
    }

    public static FilterResponseDto.getFilter toGetFilter(Filter filter) {
        return FilterResponseDto.getFilter.builder()
                .filterId(filter.getId())
                .targetAttributeId(filter.getTargetAttribute().getId())
                .keyword(filter.getKeyword())
                .filterType(filter.getFilterType().name())
                .build();
    }
}
