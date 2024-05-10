package innosage.crm.domain.filter.service;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.service.AttributeQueryAdapter;
import innosage.crm.domain.filter.Filter;
import innosage.crm.domain.filter.dto.FilterRequestDto;
import innosage.crm.domain.filter.dto.FilterResponseDto;
import innosage.crm.domain.filter.mapper.FilterMapper;
import innosage.crm.domain.sheet.Sheet;
import innosage.crm.domain.sheet.service.SheetQueryAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class FilterService {

        private final FilterCommandAdapter filterCommandAdapter;
        private final FilterQueryAdapter filterQueryAdapter;
        private final SheetQueryAdapter sheetQueryAdapter;
        private final AttributeQueryAdapter attributeQueryAdapter;

        @Transactional
        public FilterResponseDto.addFilter addFilter(Long sheetId, FilterRequestDto.addFilter request) {
            Sheet sheet = sheetQueryAdapter.findById(sheetId);
            Attribute targetAttribute = attributeQueryAdapter.findById(request.getTargetAttributeId());
            Filter filter = FilterMapper.toFilter(request.getKeyword(), request.getFilterType(), sheet, targetAttribute);
            Filter savedFilter = filterCommandAdapter.addFilter(filter);

            return FilterMapper.toAddFilter(savedFilter);
        }
}
