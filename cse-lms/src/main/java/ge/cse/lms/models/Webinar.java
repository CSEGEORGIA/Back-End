package ge.cse.lms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Webinar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date startDate;
    private Date endDate;
    private String link;
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "webinars")
    private List<AppUser> appUsers; // ანუ როგორც სტუდენტებს ასევე ლექტორებსაც ებმება ეს ვებინარი
}
