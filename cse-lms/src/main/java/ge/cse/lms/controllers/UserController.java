package ge.cse.lms.controllers;


import ge.cse.lms.DTOs.appuser.assignAppUserRole.AssignAppUserRole;
import ge.cse.lms.DTOs.appuser.getUsers.GetAppUserListOutput;
import ge.cse.lms.DTOs.appuser.registrationAppUser.RegisterAppUserInput;
import ge.cse.lms.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/users")
    public GetAppUserListOutput getUsers() {
        return appUserService.getUserList();
    }

    @PostMapping("/registrationappuser")
    public void RegistrationAppUser(@RequestBody RegisterAppUserInput registerAppUserInput) {
        appUserService.registerAppUser(registerAppUserInput);
    }

    @PostMapping("/assignappuserrole")
    public void assignAppUserRole(@RequestBody AssignAppUserRole assignAppUserRole) {
        appUserService.assignAppUserRole(assignAppUserRole);
    }

}
