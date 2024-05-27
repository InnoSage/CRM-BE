package innosage.crm.domain.sheet.service;

import innosage.crm.auth.organization.Organization;
import innosage.crm.auth.organization.service.OrganizationQueryAdapter;
import innosage.crm.domain.attribute.Attribute;
import innosage.crm.domain.attribute.dto.AttributeResponseDto;
import innosage.crm.domain.attribute.mapper.AttributeMapper;
import innosage.crm.domain.company.Company;
import innosage.crm.domain.company.service.CompanyQueryAdapter;
import innosage.crm.domain.deal.dto.DealResponseDto;
import innosage.crm.domain.deal.mapper.DealMapper;
import innosage.crm.domain.sheet.Sheet;
import innosage.crm.domain.sheet.dto.SheetRequestDto;
import innosage.crm.domain.sheet.dto.SheetResponseDto;
import innosage.crm.domain.sheet.mapper.SheetMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SheetService {

    private final SheetCommandAdapter sheetCommandAdapter;
    private final SheetQueryAdapter sheetQueryAdapter;
    private final OrganizationQueryAdapter organizationQueryAdapter;
    private final CompanyQueryAdapter companyQueryAdapter;

    @Transactional
    public SheetResponseDto.addSheet addSheet(Long organizationId, SheetRequestDto.addSheet request) {
        Organization organization = organizationQueryAdapter.findById(organizationId);
        Sheet sheet = SheetMapper.toSheet(request.getName(), organization);
        sheetCommandAdapter.addSheet(sheet);

        return SheetMapper.toAddSheet(sheet);
    }


    @Transactional(readOnly = true)
    public SheetResponseDto.getSheets getSheets(Long organizationId) {
        Organization organization = organizationQueryAdapter.findById(organizationId);
        List<Sheet> sheets = sheetQueryAdapter.findByOrganization(organization);

        return SheetMapper.toGetSheetList(sheets);
    }

    @Transactional(readOnly = true)
    public SheetResponseDto.getSheetDetails getSheet(Long sheetId) {
        Sheet sheet = sheetQueryAdapter.findById(sheetId);
        List<Attribute> attributes = sheet.getAttributes();
        List<AttributeResponseDto.getAttribute> allAttributes = AttributeMapper.toGetAttributeList(attributes);
        List<Company> companies = companyQueryAdapter.findBySheet(sheet);
        List<DealResponseDto.getDeal> allDeals = companies.stream()
                .flatMap(company -> company.getDeals().stream())  // 각 회사의 거래를 스트림으로 변환
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        DealMapper::toGetDealList  // 거래 목록을 DealResponseDto.getDeal 리스트로 변환
                ));

        return SheetMapper.toGetSheetDetails(sheet, allAttributes, allDeals, companies);
    }

    @Transactional
    public SheetResponseDto.updateSheet updateSheet(Long sheetId, SheetRequestDto.updateSheet request) {
        Sheet sheet = sheetQueryAdapter.findById(sheetId);
        sheet.update(request.getName());

        return SheetMapper.toUpdateSheet(sheet);
    }

    @Transactional
    public void deleteSheet(Long sheetId) {
        Sheet sheet = sheetQueryAdapter.findById(sheetId);
        sheetCommandAdapter.deleteSheet(sheet);
    }
}


