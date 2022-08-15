package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.*;
import HubertRoszyk.company.configuration.ConfigOperator;
import HubertRoszyk.company.Validator;
import HubertRoszyk.company.RandomDraw;
import HubertRoszyk.company.service.GalaxyService;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.UserService;
import lombok.NonNull;
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
    public Set<Planet> connectToGalaxy(@RequestBody JSONObject jsonInput) {
        @NonNull
        int userId = (int) jsonInput.get("userId");
        @NonNull
        int galaxyId = (int) jsonInput.get("galaxyId");

        User user = userService.getUserById(userId);

        Set<Planet> galaxyPlanets = planetService.getPlanetByGalaxy(galaxyId);

        //nie wiem czy nie lepiej po prostu zawsze bindować
        for (Points points : user.getPoints()) {
            if (points.getGalaxy().getId() == galaxyId) {
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

    @GetMapping("/createGalaxy")
    public List<Planet> galaxyInit(@RequestBody JSONObject request){ //do przeanalizowania bo nie wygląda za ładnie
        String galaxyName = (String) request.get("galaxyName");

        Galaxy galaxy = new Galaxy(0, galaxyName);

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

            Planet planet = new Planet(industryPointsMultiplier, sciencePointsMultiplier, size, planetLocation.xLocation, planetLocation.yLocation);
            planet.asignGalaxy(galaxy);
            planets.add(planet);
        }
        List<Planet> validatedPlanets = Validator.validatePlanetPositionInGalaxy(planets);

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

