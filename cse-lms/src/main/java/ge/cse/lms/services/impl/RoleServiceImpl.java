package ge.cse.lms.services.impl;



import ge.cse.lms.DTOs.role.addRole.AddRoleInput;
import ge.cse.lms.DTOs.role.addRole.AddRoleOutput;
import ge.cse.lms.models.AppUser;
import ge.cse.lms.DTOs.role.changeRoleAppUser.ChangeRoleAppUserInput;
import ge.cse.lms.models.Role;
import ge.cse.lms.repositories.AppUserRepository;
import ge.cse.lms.repositories.RoleRepository;
import ge.cse.lms.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }


    @Override
    public AddRoleOutput addRole(AddRoleInput addRoleInput) {
        AddRoleOutput addRoleOutput=new AddRoleOutput();
        Role role=new Role();
        if (roleRepository.findByTitle(addRoleInput.getTitle())==null) {
            role.setTitle(addRoleInput.getTitle());
            roleRepository.save(role);
            addRoleOutput.setMsg("როლი წარმატებით დაემატა");
        }else {
            addRoleOutput.setMsg("ესეთი როლი უკვე არსებობს");
        }

        return addRoleOutput;
    }

    @Override
    public void changeAppUserRole(ChangeRoleAppUserInput changeRoleAppUserInput){

        AppUser appUser=appUserRepository.findByUsername(changeRoleAppUserInput.getUsername());
        for(Role role : appUser.getRoles()){
            if(role.getTitle().equals(changeRoleAppUserInput.getCurrentTitle())){
                role.setTitle(changeRoleAppUserInput.getNewTitle());
            }
        }
    }



}
