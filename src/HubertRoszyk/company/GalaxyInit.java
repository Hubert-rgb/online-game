package HubertRoszyk.company;

import java.util.*;

public class GalaxyInit {

    public GalaxyInit(int planetsNum, int randomVariablesSum){
        List<Planet> planets = new ArrayList<>();
        ListManager listManager = ListManager.getInstance();
        Random random = new Random();

        int galaxiesNum = listManager.galaxies.size();
        int lastPlanetId = 0;
        if (galaxiesNum > 0) {
            List<Planet> lastGalaxyPlanets = listManager.galaxies.get(galaxiesNum - 1);
            lastPlanetId = lastGalaxyPlanets.get(lastGalaxyPlanets.size() - 1).id;

        }
        for(int i = 0; i < planetsNum; i++){
            int galaxyID = listManager.galaxies.size() + 1;
            int id = planets.size() + 1 + lastPlanetId;

            int size = random.nextInt(3);
            size++;
            int localRandomVariablesSum = randomVariablesSum - size;

            int industryPointsMultiplier = random.nextInt(localRandomVariablesSum - 1) + 1;
            int sciencePointsMultiplier = localRandomVariablesSum - industryPointsMultiplier;

            int xLocation = random.nextInt(1920) + 1;
            int yLocation = random.nextInt(1080) + 1;
            //validator

            Planet planet = new Planet(id, industryPointsMultiplier,sciencePointsMultiplier, size, xLocation, yLocation, 1, 1, galaxyID);
            planets.add(planet);
        }
        listManager.galaxies.add(planets);
    }
}

