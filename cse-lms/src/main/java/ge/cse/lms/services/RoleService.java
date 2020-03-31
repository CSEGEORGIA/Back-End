package ge.cse.lms.services;



import ge.cse.lms.DTOs.role.addRole.AddRoleInput;
import ge.cse.lms.DTOs.role.addRole.AddRoleOutput;
import ge.cse.lms.DTOs.role.changeRoleAppUser.ChangeRoleAppUserInput;
import ge.cse.lms.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList();

    AddRoleOutput addRole(AddRoleInput addRoleInput);

    void changeAppUserRole(ChangeRoleAppUserInput changeRoleAppUserInput);
}
