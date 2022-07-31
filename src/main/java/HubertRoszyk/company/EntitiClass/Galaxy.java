package HubertRoszyk.company.EntitiClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Galaxy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "galaxies")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "galaxy")
    private Set<Planet> enrolledPlanets = new HashSet<>();
}
