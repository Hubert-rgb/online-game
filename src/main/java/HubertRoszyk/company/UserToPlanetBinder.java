package HubertRoszyk.company;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserToPlanetBinder {
    private static final ListManager listManage = ListManager.getInstance();
    @PostMapping("/bindPlanetToUser")
    public static void bindPlanetToUser(@RequestParam int userId, int planetId) {
        List<Integer> userPlanets = listManage.usersPlanetsHashMap.get(userId);
        userPlanets.add(planetId);
        listManage.usersPlanetsHashMap.put(userId, userPlanets);
    }

}
