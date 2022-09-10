package HubertRoszyk.company.controller;

import HubertRoszyk.company.entiti_class.*;
import HubertRoszyk.company.Validator;
import HubertRoszyk.company.RandomDraw;
import HubertRoszyk.company.service.ArmyPointsService;
import HubertRoszyk.company.service.GalaxyService;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.UserService;
import lombok.NonNull;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class GalaxyController {
    @Autowired
    PlanetService planetService;

    @Autowired
    GalaxyService galaxyService;

    @Autowired
    UserService userService;

    @Autowired
    ArmyPointsService armyPointsService;

    @Autowired
    Binder binder;

    @Autowired
    Validator validator;

    //@CrossOrigin(origins = "http://127.0.0.1:5500/", allowedHeaders = "*")

    @GetMapping("/galaxy-controller/users/{userId}/galaxies/{galaxyId}")
    public Set<Planet> connectToGalaxy(@PathVariable("userId") int userId, @PathVariable("galaxyId") int galaxyId) {

        User user = userService.getUserById(userId);

        Set<Planet> galaxyPlanets = planetService.getPlanetsByGalaxy(galaxyId);

        //nie wiem czy nie lepiej po prostu zawsze bindować
        for (FactoryPoints factoryPoints : user.getPoints()) {
            if (factoryPoints.getGalaxy().getId() == galaxyId) {
                return galaxyPlanets;
            }
        }
        Galaxy galaxy = binder.bindGalaxyToUser(userId, galaxyId);
        if (galaxy == null) {
            return null;
        } else {
            return galaxyPlanets;
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/", allowedHeaders = "*")
    @PostMapping("/galaxy-controller/galaxies")
    public List<Planet> galaxyInit(/*@RequestHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN)*/ @RequestBody JSONObject jsonInput){ //do przeanalizowania bo nie wygląda za ładnie
        //json to galaxy with jackson
        int maximalUserNumber = (int) jsonInput.get("maximalUserNumber");
        String galaxyName = (String) jsonInput.get("galaxyName");

        Galaxy galaxy = new Galaxy(maximalUserNumber, galaxyName);
        galaxyService.saveGalaxy(galaxy);

        List<Planet> planets = new ArrayList<>();

        //później można tworzyć galaktyki nie posiadające każdego typu planet
        for (PlanetType planetType : PlanetType.values()) {
            planets.addAll(createPlanet(planetType, galaxy));
        }

        List<Planet> validatedPlanets = validator.validatePlanetPositionInGalaxy(planets);
        planetService.savePlanetsList(validatedPlanets);

        return validatedPlanets;
    }
    public List<Planet> createPlanet(PlanetType planetType, Galaxy galaxy) {
        List<Planet> planets = new ArrayList<>();

        int planetsNum = galaxy.getMaximalUserNumber() + 1;
        int randomVariablesSum = planetType.getRandomVariablesSum();

        for(int i = 0; i < planetsNum; i++){
            int size = RandomDraw.sizeDraw(planetType);
            size++;

            int localRandomVariablesSum = randomVariablesSum - size;

            int industryPointsMultiplier = RandomDraw.industryPointsMultiplierDraw(localRandomVariablesSum); //te dwie linijki coś bym zmienił
            int sciencePointsMultiplier = localRandomVariablesSum - industryPointsMultiplier;

            PlanetLocation planetLocation = RandomDraw.locationDraw();
            //validator

            Planet planet = new Planet(planetType,industryPointsMultiplier, sciencePointsMultiplier, size, planetLocation.xLocation, planetLocation.yLocation);
            ArmyPoints armyPoints = new ArmyPoints(planet);

            armyPointsService.saveArmyPoints(armyPoints);

            planet.asignGalaxy(galaxy);
            planets.add(planet);
        }
        return planets;
    }

    /*@GetMapping("/getPlanets")
    public List<Planet> getPlanets() {
        List<Planet> planets = planetService.getPlanetsList();


        return planets;
    }*/
    @GetMapping("/galaxy-controller/galaxies")
    public List<Galaxy> getGalaxies() {
        List<Galaxy> galaxies = galaxyService.getAllGalaxies();
        return galaxies;
    }
    @GetMapping("/galaxy-controller/galaxies/{galaxyId}")
    Set<Planet> getGalaxyById(/*@RequestBody JSONObject galaxyId*/ @PathVariable int galaxyId) {
        //int galaxyIdInt = (int) galaxyId.get("galaxyId");
        Galaxy galaxy = galaxyService.getGalaxyById(galaxyId);
        Set<Planet> planets = null;
        try {
            planets = galaxy.getEnrolledPlanets();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        //return planets
        return planets;
    }
}

