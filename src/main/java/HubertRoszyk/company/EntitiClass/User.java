package HubertRoszyk.company.EntitiClass;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
public class User {

    @Id
    private final int id;
    //private int industryPoints;
    //private int sciencePoints;
    @NonNull
    private String name;
    @NonNull
    private String password;
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
}
