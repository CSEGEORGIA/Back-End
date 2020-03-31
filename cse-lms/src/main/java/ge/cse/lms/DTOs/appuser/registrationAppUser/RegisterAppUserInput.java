package ge.cse.lms.DTOs.appuser.registrationAppUser;

import lombok.Data;

@Data
public class RegisterAppUserInput {
    private String username;
    private String password;
    private String email;
}
