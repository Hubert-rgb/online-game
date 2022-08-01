package HubertRoszyk.company.binding;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.ListManager;
import HubertRoszyk.company.service.GalaxyService;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/bindPlanetToUser")
    Planet bindPlanetToUser(@RequestParam int userId, int planetId) {
        User user = userService.getUserById(userId);
        Planet planet = planetService.getPlanetById(planetId);

        planet.asignUser(user);

        return planetService.savePlanet(planet);
    }

   // @PostMapping("/bindGalaxyToUser")
    public Galaxy bindGalaxyToUser(int userId, int galaxyId) { //user change
        User user = userService.getUserById(userId);
        Galaxy galaxy = galaxyService.getGalaxyById(galaxyId);
        //user.addGalaxy(galaxy);
        galaxy.addUser(user);

        //return userService.saveUser(user);
        return galaxyService.saveGalaxy(galaxy);
    }
    /*@PostMapping("/bindPlanetToGalaxy")
    Galaxy bindPlanetToGalaxy(@RequestParam int planetId, int galaxyId) {
        Galaxy galaxy = galaxyService.getGalaxyById(galaxyId);
        Planet planet = planetService.getPlanetById(planetId);

        planet.asignGalaxy(galaxy);

        return galaxy;
    }*/
}
