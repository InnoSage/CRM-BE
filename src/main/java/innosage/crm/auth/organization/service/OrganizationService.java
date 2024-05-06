package innosage.crm.auth.organization.service;

import innosage.crm.auth.organization.Organization;
import innosage.crm.auth.organization.dto.OrganizationRequestDto;
import innosage.crm.auth.organization.dto.OrganizationResponseDto;
import innosage.crm.auth.organization.mapper.OrganizationMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OrganizationService {

    private final OrganizationCommandAdapter organizationCommandAdapter;
    private final OrganizationQueryAdapter organizationQueryAdapter;

    @Transactional
    public OrganizationResponseDto.addOrganization addOrganization(OrganizationRequestDto.addOrganization request) {
        Organization organization = OrganizationMapper.toOrganization(request.getName());
        Organization savedOrganization = organizationCommandAdapter.addOrganization(organization);

        return OrganizationMapper.toAddOrganization(savedOrganization);
    }

    @Transactional(readOnly = true)
    public List<OrganizationResponseDto.getOrganization> getOrganizations() {
        List<Organization> organizations = organizationQueryAdapter.findAll();

        return OrganizationMapper.toGetOrganizations(organizations);
    }

//    @Transactional
//    public OrganizationResponseDto.manageOrganization updateOrganization(OrganizationRequestDto.updateOrganization request) {
//        Organization organization = organizationQueryAdapter.findById(request.getOrganizationId())
//                .orElseThrow(() -> new OrganizationException(GlobalErrorCode.ORGANIZATION_NOT_FOUND));
//        organization.updateOrganizationName(request.getOrganizationName());
//
//        return OrganizationMapper.toUpdateOrganization(organization);
//    }
}
