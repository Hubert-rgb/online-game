package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.Points;
import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.service.GalaxyService;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.PointsService;
import HubertRoszyk.company.service.UserService;
import lombok.NonNull;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class Binder {
    @Autowired
    UserService userService;

    @Autowired
    PlanetService planetService;

    @Autowired
    GalaxyService galaxyService;

    @Autowired
    PointsController pointsController;

    @PostMapping("/bindPlanetToUser")
    Planet bindPlanetToUser(@RequestBody JSONObject jsonInput) {
        int userId = (int) jsonInput.get("userId");
        int planetId = (int) jsonInput.get("planetId");

        User user = userService.getUserById(userId);
        Planet planet = planetService.getPlanetById(planetId);

        if (planet == null || user == null) {
            return null;
        } else {
            planet.asignUser(user);

            planetService.savePlanet(planet); //najpierw trzeba zapisać planetę usera a potem szukać jej punkty
            pointsController.getTotalIndustryIncome(userId, planet.getGalaxy().getId());

            return planet;
        }
    }
    public Galaxy bindGalaxyToUser(int userId, int galaxyId) {
        User user = userService.getUserById(userId);
        Galaxy galaxy = galaxyService.getGalaxyById(galaxyId);

        if (user == null || galaxy == null) {
            return null;
        } else {
            galaxy.addUser();

            pointsController.createPoints(user, galaxy);

            return galaxyService.saveGalaxy(galaxy);
        }
    }
}
