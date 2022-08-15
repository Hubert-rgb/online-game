package HubertRoszyk.company.EntitiClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Galaxy {
    //TODO 30 day countdown
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "galaxyId")
    private int id;
    private int userNumber = 0;
    @NonNull
    private int maximalUserNumber;
    @NonNull
    private String galaxyName;

    /*@JsonIgnore
    //@ManyToMany(mappedBy = "galaxies")
    @ManyToMany
    @JoinTable(
            name = "userGalaxies",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "galaxyId")
    )
    private Set<User> users = new HashSet<>();*/

    @JsonIgnore
    @OneToMany(mappedBy = "galaxy")
    private Set<Planet> enrolledPlanets = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "galaxy")
    private Set<Points> enrolledPoits = new HashSet<>();

    public void addUser() {
        //users.add(user);
        userNumber += 1;
    }
}
