package HubertRoszyk.company.ClassToInstance;

import HubertRoszyk.company.ListManager;

import java.util.List;

public class User {
    public User(int id, String Name, String password, int industryPoints, int sciencePoints){
        this.id = id;
        this.name = Name;
        this.password = password;
        this.industryPoints = industryPoints;
        this.sciencePoints = sciencePoints;
    }

    public int id, industryPoints, sciencePoints;
    public String name, password;
    public int industryPointsIncome = 0, sciencePointsIncome = 0;

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
