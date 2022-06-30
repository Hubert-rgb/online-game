package HubertRoszyk.company;

import java.util.ArrayList;
import java.util.List;

public class SortPlanetsToGalaxies {
    public static List<List<Planet>> sortPlanetsToGalaxies(List<Planet> planetsList){
        List<List<Planet>> galaxies = new ArrayList<>();
        List<Planet> planetsInGalaxy = new ArrayList<>();
        planetsInGalaxy.add(planetsList.get(0));
        for (int i = 1; i < planetsList.size(); i++) {
            if (planetsList.get(i).galaxyNum == planetsList.get(i - 1).galaxyNum) {
                planetsInGalaxy.add(planetsList.get(i));
            } else {
                galaxies.add(planetsInGalaxy);
                planetsInGalaxy.removeAll(planetsInGalaxy);
                planetsInGalaxy.add(planetsList.get(i));
            }
        }
        galaxies.add(planetsInGalaxy);
        return galaxies;
    }
}
