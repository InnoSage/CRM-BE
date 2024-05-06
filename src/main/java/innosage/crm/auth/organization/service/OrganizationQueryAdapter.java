package innosage.crm.auth.organization.service;

import innosage.crm.auth.organization.Organization;
import innosage.crm.auth.organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrganizationQueryAdapter {

    private final OrganizationRepository organizationRepository;

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
}
