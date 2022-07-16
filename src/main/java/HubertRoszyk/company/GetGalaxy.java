package HubertRoszyk.company;

import HubertRoszyk.company.ClassToInstance.Planet;
import net.maritimecloud.internal.core.javax.json.Json;
import net.maritimecloud.internal.core.javax.json.JsonArray;
import net.maritimecloud.internal.core.javax.json.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetGalaxy {
    private final static ListManager listManager = ListManager.getInstance();
    @GetMapping("/getGalaxy")
    public static JSONArray getUserGalaxy(@RequestParam int userId) {
        int galaxyId = listManager.userGalaxy.get(userId);
        List<Planet> galaxy = listManager.galaxies.get(galaxyId - 1);

        JSONArray jsonArray = new JSONArray();
        for (Planet planet: galaxy) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", planet.id);
            jsonObject.put("industryPointsMultiplier", planet.industryPointsMultiplier);
            jsonObject.put("sciencePointsMultiplier", planet.sciencePointsMultiplier);
            jsonObject.put("size", planet.size);
            jsonObject.put("xLocation", planet.planetLocation.xLocation);
            jsonObject.put("yLocation", planet.planetLocation.yLocation);
            jsonObject.put("industryPointsProduce", planet.industryPointsProduce);
            jsonObject.put("sciencePointsProduce", planet.sciencePointsProduce);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
