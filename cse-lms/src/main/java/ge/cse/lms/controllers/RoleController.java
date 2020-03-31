package ge.cse.lms.controllers;



import ge.cse.lms.DTOs.role.addRole.AddRoleInput;
import ge.cse.lms.DTOs.role.addRole.AddRoleOutput;
import ge.cse.lms.DTOs.role.changeRoleAppUser.ChangeRoleAppUserInput;
import ge.cse.lms.models.Role;
import ge.cse.lms.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleService.getRoleList();
    }


    @PostMapping("/role")
    public AddRoleOutput addRole(@RequestBody AddRoleInput addRoleInput) {
       return roleService.addRole(addRoleInput);
    }

    @PostMapping("/changerole")
    public void changeAppUserRole(@RequestBody ChangeRoleAppUserInput changeRoleAppUserInput) {
         roleService.changeAppUserRole(changeRoleAppUserInput);
    }

}
