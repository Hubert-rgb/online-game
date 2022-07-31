package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.ListManager;
import HubertRoszyk.company.SortPlanetsToGalaxies;
import HubertRoszyk.company.service.PlanetService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetGalaxy {
    @Autowired
    PlanetService planetService;
    private final static ListManager listManager = ListManager.getInstance();
    /*@GetMapping("/getUserGalaxy")
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
    }*/
    /*@GetMapping("/getGalaxies")
    public List<List<Planet>> getGalaxies() {
        List<Planet> planets = planetService.getPlanetsList();
        *//*List<List<Planet>> galaxies = SortPlanetsToGalaxies.sortPlanetsToGalaxies(planets);*//*

        return galaxies;
    }*/
}
