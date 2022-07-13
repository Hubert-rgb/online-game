package HubertRoszyk.company;

import java.util.ArrayList;
import java.util.List;

public class GalaxyInit {

    public GalaxyInit(int planetsNum, int randomVariablesSum){ //do przeanalizowania bo nie wygląda za ładnie
        List<Planet> planets = new ArrayList<>();
        ListManager listManager = ListManager.getInstance();

        int galaxiesNum = listManager.galaxies.size();
        int lastPlanetId = 0;
        if (galaxiesNum > 0) {
            List<Planet> lastGalaxyPlanets = listManager.galaxies.get(galaxiesNum - 1);
            lastPlanetId = lastGalaxyPlanets.get(lastGalaxyPlanets.size() - 1).id;

        }
        for(int i = 0; i < planetsNum; i++){
            int galaxyID = listManager.galaxies.size() + 1;
            int id = planets.size() + 1 + lastPlanetId;

            int size = RandomDraw.sizeDraw(); //nie wiem czy tego inaczej nie zrobić
            size++;
            int localRandomVariablesSum = randomVariablesSum - size;

            int industryPointsMultiplier = RandomDraw.industryPointsMultiplierDraw(localRandomVariablesSum); //te dwie linijki coś bym zmienił
            int sciencePointsMultiplier = localRandomVariablesSum - industryPointsMultiplier;

            PlanetLocation planetLocation = RandomDraw.locationDraw();
            //validator

            Planet planet = new Planet(id, industryPointsMultiplier,sciencePointsMultiplier, size, planetLocation, 1, 1, galaxyID);
            planets.add(planet);
        }
        List<Planet> validatedPlanets = PlanetDataValidator.validatePlanetPositionInGalaxy(planets);
        listManager.galaxies.add(validatedPlanets);
    }
}

