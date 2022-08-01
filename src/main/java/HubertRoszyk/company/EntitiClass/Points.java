package HubertRoszyk.company.EntitiClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Points {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pointsId")
    private int id;

    private int industryPoints;
    private int sciencePoints;

    private int industryPointsIncome;
    private int sciencePointsIncome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "galaxyId", referencedColumnName = "galaxyId")
    private Galaxy galaxy;

    /*public void getTotalIndustryIncome() {
        List<Planet> userPlanets = listManager.usersPlanetsHashMap.get(id);
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

    public void assignUser(User user) {
        this.user = user;
    }
    public void assignGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }
}
