package ge.cse.lms.DTOs.webinar;
import lombok.Data;
import java.util.List;

@Data
public class AssignAppUserListWebinar {
    private String webinarId;
    private List<String> usernameList;
}
