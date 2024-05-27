package innosage.crm.domain.sheet.service;

import innosage.crm.domain.sheet.Sheet;
import innosage.crm.domain.sheet.repository.SheetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SheetCommandAdapter {

    private final SheetRepository sheetRepository;

    public void addSheet(Sheet sheet) {
        sheetRepository.save(sheet);
    }

    public void deleteSheet(Sheet sheet) {
        sheetRepository.delete(sheet);
    }
}
