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
    @NonNull
    @Column(name = "userId")
    private int id;
    //private int industryPoints;
    //private int sciencePoints;
    @NonNull
    private String name;
    @NonNull
    private String password;

    @JsonIgnore //jak to działa?
    @OneToMany(mappedBy = "user")
    private Set<Planet> enrolledPlanets = new HashSet<>();


    @ManyToMany()
    @JoinTable (
            name = "userGalaxies",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "galaxyId")
    )
    private Set<Galaxy> galaxies = new HashSet<>();
    //private int industryPointsIncome;
    //private int sciencePointsIncome;

    /*public void getTotalIndustryIncome() {
        ListManager listManager = ListManager.getInstance();
        List<Integer> userPlanets = listManager.usersPlanetsHashMap.get(id);
        if (userPlanets != null) {
            for (int planetIndex: userPlanets) {
                for (Planet planet : listManager.planets){
                    if(planet.getId() == userPlanets.get(planetIndex - 1)){
                        industryPointsIncome += planet.getIndustryPointsMultiplier() * planet.getIndustryPointsProduce();
                        sciencePointsIncome += planet.getSciencePointsMultiplier() * planet.getSciencePointsProduce();
                    }
                }
            }
        }

    }*/
    /*public void addGalaxy(int galaxyId) {
        galaxies.add(galaxyId);
    }*/

}
