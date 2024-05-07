package innosage.crm.domain.sheet.service;

import innosage.crm.auth.organization.Organization;
import innosage.crm.domain.sheet.Sheet;
import innosage.crm.domain.sheet.repository.SheetRepository;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import innosage.crm.global.exception.sheet.SheetException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SheetQueryAdapter {

    private final SheetRepository sheetRepository;

    public Sheet findById(Long id) {
        return sheetRepository.findById(id).orElseThrow(()->new SheetException(GlobalErrorCode.SHEET_NOT_FOUND));
    }

    public List<Sheet> findByOrganization(Organization organization) {
        return sheetRepository.findAllByOrganization(organization);
    }
}
