package innosage.crm.auth.organization.mapper;

import innosage.crm.auth.organization.Organization;
import innosage.crm.auth.organization.dto.OrganizationResponseDto;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class OrganizationMapper {

    public static Organization toOrganization(String name) {
        return Organization.builder()
                .name(name)
                .build();
    }

    public static OrganizationResponseDto.addOrganization toAddOrganization(Organization organization) {
        return OrganizationResponseDto.addOrganization.builder()
                .organizationId(organization.getId())
                .organizationName(organization.getName())
                .build();
    }

    public static OrganizationResponseDto.getOrganization toGetOrganization(Organization organization) {
        return OrganizationResponseDto.getOrganization.builder()
                .organizationId(organization.getId())
                .organizationName(organization.getName())
                .build();
    }

    public static List<OrganizationResponseDto.getOrganization> toGetOrganizations(List<Organization> organizations) {
        return organizations.stream()
                .map(OrganizationMapper::toGetOrganization)
                .toList();
    }

}
