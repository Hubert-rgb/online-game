package HubertRoszyk.company.EntitiClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Planet> enrolledPlanets = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Points> points = new HashSet<>();
}
