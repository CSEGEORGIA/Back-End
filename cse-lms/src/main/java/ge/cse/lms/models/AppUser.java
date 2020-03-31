package ge.cse.lms.models;

import ge.cse.lms.enums.GenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(unique=true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private GenderType genderType;
    private Date birthDate;
    private String email;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Webinar> webinars;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Role> roles;

}
