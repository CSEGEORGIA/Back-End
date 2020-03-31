package ge.cse.lms.DTOs.webinar;

import lombok.Data;

import java.util.Date;

@Data
public class CreateWebinarInput {
    private String title;
    private Date startDate;
    private Date endDate;
    private String link;
}
