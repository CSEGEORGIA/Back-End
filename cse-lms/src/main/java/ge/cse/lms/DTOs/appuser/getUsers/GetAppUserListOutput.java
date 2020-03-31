package ge.cse.lms.DTOs.appuser.getUsers;

import ge.cse.lms.DTOs.appuser.GetAppUserOutput;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetAppUserListOutput {
    List<GetAppUserOutput> appUserList=new ArrayList<>();
}
