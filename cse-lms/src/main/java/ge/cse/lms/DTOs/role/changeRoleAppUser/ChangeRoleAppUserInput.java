package ge.cse.lms.DTOs.role.changeRoleAppUser;

import lombok.Data;

@Data
public class ChangeRoleAppUserInput {
    private String  username;
    private String currentTitle;
    private String newTitle;
}
