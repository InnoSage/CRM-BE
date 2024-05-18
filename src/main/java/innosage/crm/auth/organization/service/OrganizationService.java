package innosage.crm.auth.organization.service;

import innosage.crm.auth.member.entity.Member;
import innosage.crm.auth.member.service.MemberQueryAdapter;
import innosage.crm.auth.organization.Organization;
import innosage.crm.auth.organization.dto.OrganizationRequestDto;
import innosage.crm.auth.organization.dto.OrganizationResponseDto;
import innosage.crm.auth.organization.mapper.OrganizationMapper;
import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
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
    private final MemberQueryAdapter memberQueryAdapter;

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

    @Transactional
    public OrganizationResponseDto.updateMember updateMember(Long organizationId, OrganizationRequestDto.updateMember request) {
        Organization organization = organizationQueryAdapter.findById(organizationId);
        List<Member> members = request.getMemberIds().stream().map(memberQueryAdapter::findById).toList();
        organization.updateMember(members);
        members.forEach(member -> {
            if ((member.getOrganization() == null) || (!member.getOrganization().equals(organization))) {
                member.setOrganization(organization);
            }
        });

        return OrganizationMapper.toUpdateMember(organization);
    }
}
