package HubertRoszyk.company;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListManager {
    private static  ListManager instance;
    public static ListManager getInstance() {
        if (instance == null) {
            instance = new ListManager();
        }
        return instance;
    }

    public List<List<Planet>> galaxies = new ArrayList<>();
    public List<User> users = new ArrayList<>();
    public List<Planet> planets = new ArrayList<>();
    public HashMap<Integer, List<Integer>> usersPlanetsHashMap = new HashMap<>();
    public HashMap<Integer, Integer> userGalaxy = new HashMap<>();
    public List<Building> buildings = new ArrayList<>();

    /*public void updatePlanet(int id, Planet planet) throws SQLException {
        planets.set(id - 1, planet);

        List<Planet> galaxy = galaxies.get(planet.getGalaxyNum() - 1);
        galaxy.set(id - 1, planet);
        galaxies.set(planet.getGalaxyNum() - 1, galaxy);

        DatabasePlanetManager.updatePlanetInDatabase(planet);
    }*/
    /*public void getDataFromDatabase() throws SQLException {
        getPlanetsFormDatabase();
    }*/
    /*public void getPlanetsFormDatabase() throws SQLException {
        List<Planet> planetsFromDatabase = DatabasePlanetManager.getPlanetsFromDatabase();

        List<List<Planet>> galaxies = SortPlanetsToGalaxies.sortPlanetsToGalaxies(planetsFromDatabase);
        this.galaxies = galaxies;
        this.planets = planetsFromDatabase;
    }*/
}
