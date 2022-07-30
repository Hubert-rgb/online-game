package HubertRoszyk.company;

import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.PlanetLocation;

import java.util.ArrayList;
import java.util.List;

public class GalaxyInit {

    public GalaxyInit(){ //do przeanalizowania bo nie wygląda za ładnie
        List<Planet> planets = new ArrayList<>();
        ListManager listManager = ListManager.getInstance();

        int planetsNum = ConfigOperator.planetsNum;
        int randomVariablesSum = ConfigOperator.randomVariablesSum;
        int galaxiesNum = listManager.galaxies.size();
        int lastPlanetId = 0;
        if (galaxiesNum > 0) {
            List<Planet> lastGalaxyPlanets = listManager.galaxies.get(galaxiesNum - 1);
            lastPlanetId = lastGalaxyPlanets.get(lastGalaxyPlanets.size() - 1).getId();

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

            Planet planet = new Planet(id, industryPointsMultiplier, sciencePointsMultiplier, size, 1, 1, 1, planetLocation);
            planets.add(planet);
        }
        List<Planet> validatedPlanets = PlanetDataValidator.validatePlanetPositionInGalaxy(planets);
        listManager.galaxies.add(validatedPlanets);

        for (Planet planet : validatedPlanets) {
            listManager.planets.add(planet);
        }
    }
}

