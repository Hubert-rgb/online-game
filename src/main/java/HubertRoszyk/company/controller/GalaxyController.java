package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.ConfigOperator;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.PlanetLocation;
import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.PlanetDataValidator;
import HubertRoszyk.company.RandomDraw;
import HubertRoszyk.company.binding.Binder;
import HubertRoszyk.company.service.GalaxyService;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://127.0.0.1:5500/", allowedHeaders = "*")
@RestController
public class GalaxyController {
    @Autowired
    PlanetService planetService;

    @Autowired
    GalaxyService galaxyService;

    @Autowired
    UserService userService;

    @Autowired
    Binder binder;

    @GetMapping("/connectToGalaxy")
    public List<Planet> connectToGalaxy(@RequestParam int userId, int galaxyId) {
        User user = userService.getUserById(userId);

        List<Planet> galaxyPlanets = planetService.getPlanetByGalaxy(galaxyId);

        //nie wiem czy nie lepiej po prostu zawsze bindować
        for (Galaxy galaxy : user.getGalaxies()) {
            if (galaxy.getId() == galaxyId) {
                return galaxyPlanets;
            }
        }
        binder.bindGalaxyToUser(userId, galaxyId);
        return galaxyPlanets;
    }

    @GetMapping("/createGalaxy")
    public List<Planet> galaxyInit(){ //do przeanalizowania bo nie wygląda za ładnie
        Galaxy galaxy = new Galaxy();

        List<Planet> planets = new ArrayList<>();

        int planetsNum = ConfigOperator.planetsNum;
        int randomVariablesSum = ConfigOperator.randomVariablesSum;

        for(int i = 0; i < planetsNum; i++){

            int size = RandomDraw.sizeDraw(); //nie wiem czy tego inaczej nie zrobić
            size++;
            int localRandomVariablesSum = randomVariablesSum - size;

            int industryPointsMultiplier = RandomDraw.industryPointsMultiplierDraw(localRandomVariablesSum); //te dwie linijki coś bym zmienił
            int sciencePointsMultiplier = localRandomVariablesSum - industryPointsMultiplier;

            PlanetLocation planetLocation = RandomDraw.locationDraw();
            //validator

            Planet planet = new Planet(industryPointsMultiplier, sciencePointsMultiplier, size, planetLocation.xLocation, planetLocation.yLocation, planetLocation);
            planet.asignGalaxy(galaxy);
            planets.add(planet);
        }
        List<Planet> validatedPlanets = PlanetDataValidator.validatePlanetPositionInGalaxy(planets);

        planetService.savePlanetsList(validatedPlanets);
        galaxyService.saveGalaxy(galaxy);

        return validatedPlanets;
    }

    @GetMapping("/getPlanets")
    public List<Planet> getPlanets() {
        List<Planet> planets = planetService.getPlanetsList();


        return planets;
    }
    @GetMapping("/getGalaxies")
    public List<Galaxy> getGalaxies() {
        List<Galaxy> galaxies = galaxyService.getAllGalaxies();
        return galaxies;
    }
    @GetMapping("/getGalaxyById")
    Set<Planet> getGalaxyById(@RequestBody JSONObject galaxyId) {
        int galaxyIdInt = (int) galaxyId.get("galaxyId");
        Galaxy galaxy = galaxyService.getGalaxyById(galaxyIdInt);
        Set<Planet> planets = galaxy.getEnrolledPlanets();

        //return planets
        return planets;
    }
}

