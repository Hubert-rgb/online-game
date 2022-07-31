package HubertRoszyk.company.binding;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.ListManager;
import HubertRoszyk.company.service.GalaxyService;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Binder {
    @Autowired
    UserService userService;

    @Autowired
    PlanetService planetService;

    @Autowired
    GalaxyService galaxyService;

    private static final ListManager listManage = ListManager.getInstance();
    @PostMapping("/bindPlanetToUser")
    Planet bindPlanetToUser(@RequestParam int userId, int planetId) {
        /*List<Integer> userPlanets = listManage.usersPlanetsHashMap.get(userId);
        userPlanets.add(planetId);
        listManage.usersPlanetsHashMap.put(userId, userPlanets);*/

        User user = userService.getUserById(userId);
        Planet planet = planetService.getPlanetById(planetId);

        planet.asignUser(user);

        return planetService.savePlanet(planet);
        //update in db
    }

    /*@PostMapping("/bindGalaxyToUser")
    public User bindGalaxyToUser(@RequestParam int userId, int galaxyId) {
        User user = userService.getUserById(userId);
        user.addGalaxy(galaxyId);

        return userService.saveUser(user);
        //update in db
    }*/
    @PostMapping("bindPlanetToGalaxy")
    Galaxy bindPlanetToGalaxy(@RequestParam int planetId, int galaxyId) {
        Galaxy galaxy = galaxyService.getGalaxyById(galaxyId);
        Planet planet = planetService.getPlanetById(planetId);

        planet.asignGalaxy(galaxy);

        return galaxy;
    }
}
