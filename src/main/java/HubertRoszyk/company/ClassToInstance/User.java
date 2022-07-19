package HubertRoszyk.company.ClassToInstance;

import HubertRoszyk.company.ListManager;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    private int id;
    private int industryPoints;
    private int sciencePoints;
    private String name;
    private String password;
    private int industryPointsIncome;
    private int sciencePointsIncome;

    public void getTotalIndustryIncome() {
        ListManager listManager = ListManager.getInstance();
        List<Integer> userPlanets = listManager.usersPlanetsHashMap.get(id);
        if (userPlanets != null) {
            for (int planetIndex: userPlanets) {
                for (Planet planet : listManager.planets){
                    if(planet.id == userPlanets.get(planetIndex - 1)){
                        industryPointsIncome += planet.industryPointsMultiplier * planet.industryPointsProduce;
                        sciencePointsIncome += planet.sciencePointsMultiplier * planet.sciencePointsProduce;
                    }
                }
            }
        }

    }
}
