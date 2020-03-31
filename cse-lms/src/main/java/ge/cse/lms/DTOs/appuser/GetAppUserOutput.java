package ge.cse.lms.DTOs.appuser;

import ge.cse.lms.enums.GenderType;
import lombok.Data;

import java.util.Date;

@Data
public class GetAppUserOutput {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private GenderType genderType;
    private Date birthDate;
    private String email;
}
