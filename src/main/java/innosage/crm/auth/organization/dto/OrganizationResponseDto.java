package innosage.crm.auth.organization.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrganizationResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addOrganization {
        private Long organizationId;
        private String organizationName;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getOrganization {
        private Long organizationId;
        private String organizationName;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateMember {
        private Long organizationId;
    }
}
