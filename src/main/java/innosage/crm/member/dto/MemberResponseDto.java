package innosage.crm.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {

    private Long userId;
    private String userName;
    private String email;
    private String phoneNumber;

    // Static method to create DTO from Member entity
    public static MemberResponseDto of(innosage.crm.member.entity.Member member) {
        return new MemberResponseDto(
                member.getId(),
                member.getUsername(),
                member.getEmail(),
                member.getPhoneNumber()
        );
    }
}
