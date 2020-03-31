package ge.cse.lms.services.impl;


import ge.cse.lms.DTOs.appuser.assignAppUserRole.AssignAppUserRole;
import ge.cse.lms.DTOs.appuser.getUsers.GetAppUserListOutput;
import ge.cse.lms.DTOs.appuser.GetAppUserOutput;
import ge.cse.lms.DTOs.appuser.registrationAppUser.RegisterAppUserInput;
import ge.cse.lms.models.AppUser;
import ge.cse.lms.models.Role;
import ge.cse.lms.repositories.AppUserRepository;
import ge.cse.lms.repositories.RoleRepository;
import ge.cse.lms.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public GetAppUserListOutput getUserList() {
        GetAppUserListOutput getAppUserListOutput = new GetAppUserListOutput();
        for (AppUser appUser : appUserRepository.findAll()) {
            GetAppUserOutput getAppUserOutput = new GetAppUserOutput();
            getAppUserOutput.setUsername(appUser.getUsername());
            getAppUserOutput.setFirstName(appUser.getFirstName());
            getAppUserOutput.setLastName(appUser.getLastName());
            getAppUserOutput.setBirthDate(appUser.getBirthDate());
            getAppUserOutput.setGenderType(appUser.getGenderType());
            getAppUserOutput.setPassword(appUser.getPassword());
            getAppUserOutput.setEmail(appUser.getEmail());
            getAppUserListOutput.getAppUserList().add(getAppUserOutput);
        }
        return getAppUserListOutput;
    }



    @Override
    public void registerAppUser(RegisterAppUserInput registerAppUserInput) {
        AppUser appUser = new AppUser();
        appUser.setUsername(registerAppUserInput.getUsername());
        appUser.setPassword(encoder.encode(registerAppUserInput.getPassword()));

        List<Role> roleList = new ArrayList<>();
        Role role = roleRepository.findByTitle("USER");
        if (role != null) {
            roleList.add(role); // საწყისი როლი ენიჭება USER -ი
            appUser.setRoles(roleList);
            appUserRepository.save(appUser);
            System.out.println("მომხმარებელი წარმატებით დაემატა");
        } else {
            System.out.println("მომხმარებელი ვერ დაემატა რადგან როლი USER -ი არ არსებობს");
        }
    }

    public void assignAppUserRole(AssignAppUserRole assignAppUserRole) {
        AppUser appUser = appUserRepository.findByUsername(assignAppUserRole.getUsername());
        Role role = roleRepository.findByTitle(assignAppUserRole.getTitle());
        appUser.getRoles().add(role);
        System.out.println("ახალი როლი წარმატებით მიენიჭა");

        appUserRepository.save(appUser);

    }


}