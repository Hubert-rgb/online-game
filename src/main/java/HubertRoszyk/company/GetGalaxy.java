package HubertRoszyk.company;

import HubertRoszyk.company.EntitiClass.Planet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetGalaxy {
    private final static ListManager listManager = ListManager.getInstance();
    @GetMapping("/getUserGalaxy")
    public static JSONArray getUserGalaxy(@RequestParam int userId) {
        int galaxyId = listManager.userGalaxy.get(userId);
        List<Planet> galaxy = listManager.galaxies.get(galaxyId - 1);

        JSONArray jsonArray = new JSONArray();
        for (Planet planet: galaxy) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", planet.getId());
            jsonObject.put("industryPointsMultiplier", planet.getIndustryPointsMultiplier());
            jsonObject.put("sciencePointsMultiplier", planet.getSciencePointsMultiplier());
            jsonObject.put("size", planet.getSize());
            jsonObject.put("xLocation", planet.getPlanetLocation().xLocation);
            jsonObject.put("yLocation", planet.getPlanetLocation().yLocation);
            jsonObject.put("industryPointsProduce", planet.getIndustryPointsProduce());
            jsonObject.put("sciencePointsProduce", planet.getSciencePointsProduce());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
    @GetMapping("/getGalaxies")
    public static JSONArray getGalaxies() {
        JSONArray galaxiesJsonArray = new JSONArray();
        for (List<Planet> planets : listManager.galaxies) {
            JSONArray planetsJsonArray = new JSONArray();
            for (Planet planet : planets) {
                JSONObject planetJsonObject = new JSONObject();
                planetJsonObject.put("id", planet.getId());
                planetJsonObject.put("industryPointsMultiplier", planet.getIndustryPointsMultiplier());
                planetJsonObject.put("sciencePointsMultiplier", planet.getSciencePointsMultiplier());
                planetJsonObject.put("size", planet.getSize());
                planetJsonObject.put("xLocation", planet.getPlanetLocation().xLocation);
                planetJsonObject.put("yLocation", planet.getPlanetLocation().yLocation);
                planetJsonObject.put("industryPointsProduce", planet.getIndustryPointsProduce());
                planetJsonObject.put("sciencePointsProduce", planet.getSciencePointsProduce());
                planetsJsonArray.add(planetJsonObject);
            }
            galaxiesJsonArray.add(planetsJsonArray);
        }
        return galaxiesJsonArray;
    }
}
