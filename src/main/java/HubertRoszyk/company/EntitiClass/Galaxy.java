package HubertRoszyk.company.EntitiClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Galaxy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    //@ManyToMany(mappedBy = "galaxies")
    @ManyToMany
    @JoinTable(
            name = "userGalaxies",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "galaxyId")
    )
    private Set<User> users = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "galaxy")
    private Set<Planet> enrolledPlanets = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
    }
}
