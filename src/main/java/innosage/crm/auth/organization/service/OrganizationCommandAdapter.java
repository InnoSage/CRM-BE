package innosage.crm.auth.organization.service;

import innosage.crm.auth.organization.Organization;
import innosage.crm.auth.organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrganizationCommandAdapter {

    private final OrganizationRepository organizationRepository;

    public Organization addOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }
}
