package HubertRoszyk.company;

import HubertRoszyk.company.ClassToInstance.Planet;
import HubertRoszyk.company.ClassToInstance.User;
import HubertRoszyk.company.database.DatabasePlanetManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        DatabasePlanetManager.removePlanetData();
        ConfigOperator configOperator = new ConfigOperator();
        ListManager listManager = ListManager.getInstance();

        List<Planet> planetsFromDatabase = DatabasePlanetManager.getPlanetsFromDatabase();

        List<List<Planet>> galaxies = SortPlanetsToGalaxies.sortPlanetsToGalaxies(planetsFromDatabase);
        listManager.galaxies = galaxies;
        listManager.planets = planetsFromDatabase;

        new GalaxyInit(ConfigOperator.planetsNum, ConfigOperator.randomVariablesSum);

        for (Planet planet :listManager.galaxies.get(listManager.galaxies.size() - 1)) {
            DatabasePlanetManager.addPlanetToDatabase(planet);
        }
        //ten blok jest do wywalenia
        User user1 = new User(1, "Tynom", 0, 0);
        listManager.users.add(user1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        listManager.usersPlanetsHashMap.put(1, list);
        listManager.userGalaxy.put(1, 1);
        user1.getTotalIndustryIncome();
        //GetUserData.creatingNewUser();

        PointGenerator.generatePoints();

    }
}
