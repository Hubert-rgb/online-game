package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.ConfigOperator;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.PlanetLocation;
import HubertRoszyk.company.ListManager;
import HubertRoszyk.company.PlanetDataValidator;
import HubertRoszyk.company.RandomDraw;
import HubertRoszyk.company.service.GalaxyService;
import HubertRoszyk.company.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GalaxyInit {
    @Autowired
    PlanetService planetService;

    @Autowired
    GalaxyService galaxyService;
    @GetMapping("/createGalaxy")
    public List<Planet> galaxyInit(@RequestParam int userId){ //do przeanalizowania bo nie wygląda za ładnie
        Galaxy galaxy = new Galaxy();

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

            Planet planet = new Planet(id, industryPointsMultiplier, sciencePointsMultiplier, size, planetLocation.xLocation, planetLocation.yLocation, planetLocation);
            planet.asignGalaxy(galaxy);
            planets.add(planet);
        }
        List<Planet> validatedPlanets = PlanetDataValidator.validatePlanetPositionInGalaxy(planets);
        //listManager.galaxies.add(validatedPlanets);

        //UserToGalaxyBind binder = new UserToGalaxyBind();
        //binder.bindGalaxyToUser(userId, galaxiesNum + 1);

        planetService.savePlanetsList(validatedPlanets);
        //listManager.planets.addAll(validatedPlanets);

        galaxyService.saveGalaxy(galaxy);



        return validatedPlanets;
    }
}

