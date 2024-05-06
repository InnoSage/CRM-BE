package innosage.crm.auth.organization.dto;

import lombok.Getter;

import java.util.List;

public class OrganizationRequestDto {

    @Getter
    public static class addOrganization {

        private String name;
    }

    @Getter
    public static class manageOrganization {

        private List<Long> memberIds;
    }
}
