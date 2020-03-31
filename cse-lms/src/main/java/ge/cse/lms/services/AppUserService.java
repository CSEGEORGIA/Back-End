package ge.cse.lms.services;



import ge.cse.lms.DTOs.appuser.assignAppUserRole.AssignAppUserRole;
import ge.cse.lms.DTOs.appuser.getUsers.GetAppUserListOutput;
import ge.cse.lms.DTOs.appuser.registrationAppUser.RegisterAppUserInput;

public interface AppUserService {
    GetAppUserListOutput getUserList();

    void registerAppUser(RegisterAppUserInput registerAppUserInput);

    void assignAppUserRole(AssignAppUserRole assignAppUserRole);
}
