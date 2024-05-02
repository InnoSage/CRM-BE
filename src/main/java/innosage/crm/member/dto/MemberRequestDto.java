package innosage.crm.member.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class MemberRequestDto {

    @Getter
    public static class register {

//        @NotBlank(message = "Email is required")
//        @Email(message = "Email should be valid")
        private String email;

//        @NotBlank(message = "Username is required")
//        @Size(max = 25, message = "Username must be 25 characters or less")
        private String userName;

//        @NotBlank(message = "Password is required")
//        @Size(min = 12, max = 50, message = "Password must be between 12 and 50 characters")
//        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{12,50}$", message = "Password must include uppercase, lowercase, number, and special character")
        private String password;

//        @NotBlank(message = "Phone number is required")
//        @Pattern(regexp = "^\\d{11}$", message = "Phone number must be 11 digits and contain only numbers")
        private String phoneNumber;
    }

    @Getter
    public static class login {
        private String email;
        private String password;
    }

    @Getter
    public static class reissue {

        @NotNull
        @NotBlank
        private String refreshToken;
    }



}
