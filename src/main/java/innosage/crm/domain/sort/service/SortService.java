package innosage.crm.domain.sort.service;

import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.service.AttributeQueryAdapter;
import innosage.crm.domain.sheet.Sheet;
import innosage.crm.domain.sheet.service.SheetQueryAdapter;
import innosage.crm.domain.sort.Sort;
import innosage.crm.domain.sort.dto.SortRequestDto;
import innosage.crm.domain.sort.dto.SortResponseDto;
import innosage.crm.domain.sort.mapper.SortMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class SortService {

    private final SortCommandAdapter sortCommandAdapter;
    private final SortQueryAdapter sortQueryAdapter;
    private final SheetQueryAdapter sheetQueryAdapter;
    private final AttributeQueryAdapter attributeQueryAdapter;

    @Transactional
    public SortResponseDto.addSort addSort(Long sheetId, SortRequestDto.addSort request) {
        Sheet sheet = sheetQueryAdapter.findById(sheetId);
        Attribute targetAttribute = attributeQueryAdapter.findById(request.getTargetAttributeId());
        Sort sort = SortMapper.toSort(request.getSortType(), sheet, targetAttribute);
        Sort savedSort = sortCommandAdapter.addSort(sort);

        return SortMapper.toAddSort(savedSort);
    }
}
