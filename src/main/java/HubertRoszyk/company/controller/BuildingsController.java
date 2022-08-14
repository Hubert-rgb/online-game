package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.BuildingsType;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.Points;
import HubertRoszyk.company.StringToBuildingsTypeConverter;
import HubertRoszyk.company.configuration.ConfigOperator;
import HubertRoszyk.company.service.BuildingService;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.PointsService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingsController { //dodaje, updatuje i usuwa budynki

    //musi updatować industry points i total industry points
    @Autowired
    BuildingService buildingService;

    @Autowired
    PlanetService planetService;

    @Autowired
    PointsController pointsController;

    @Autowired
    PointsService pointsService;

    @Autowired
    StringToBuildingsTypeConverter converter;

    @PostMapping("/addBuilding")
    public String addBuilding(@RequestBody JSONObject jsonInput) {
        int planetId = (int) jsonInput.get("planetId");
        int userId = (int) jsonInput.get("userId");
        String buildingsTypeString = (String) jsonInput.get("buildingsType");

        BuildingsType buildingsType = converter.convert(buildingsTypeString);

        Planet planet = planetService.getPlanetById(planetId);
        Points points = pointsService.getPointsByUserIdAndGalaxyId(userId, planet.getGalaxy().getId());

        Building building = new Building(buildingsType, 1);
        building.setPlanet(planet);

        double buildingPrice = getBuildingPrice(building);
        double gotIndustryPoints = points.getIndustryPoints();

        System.out.println("building Price = " + buildingPrice);
        System.out.println("Points = " + gotIndustryPoints);

        if (gotIndustryPoints >= buildingPrice) {
            double setIndustryPoints = gotIndustryPoints - buildingPrice;
            points.setIndustryPoints(setIndustryPoints);

            //upgradeIncome

            buildingService.saveBuilding(building);

            pointsController.getTotalIndustryIncome(userId, planet.getGalaxy().getId());
            pointsService.savePoints(points);
            return "added";
        } else {
            return "not enough points";
        }
    }
    @PostMapping("/upgradeBuilding")
    public String upgradeBuilding(@RequestBody JSONObject jsonInput) {
        int userId = (int) jsonInput.get("userId");
        int buildingId = (int) jsonInput.get("buildingId");

        Building building = buildingService.getBuildingById(buildingId);
        Points points = pointsService.getPointsByUserIdAndGalaxyId(userId, building.getPlanet().getGalaxy().getId());

        int buildingLevel = building.getBuildingLevel();
        buildingLevel ++;

        building.setBuildingLevel(buildingLevel);

        double buildingPrice = getBuildingPrice(building);
        double gotIndustryPoints = points.getIndustryPoints();

        System.out.println("building Price = " + buildingPrice);
        System.out.println("Points = " + gotIndustryPoints);

        if(gotIndustryPoints >= buildingPrice) { //tego ifa moża do funkci wywalić
            double setIndustryPoints = gotIndustryPoints - buildingPrice;
            points.setIndustryPoints(setIndustryPoints);

            pointsController.getTotalIndustryIncome(userId, building.getPlanet().getGalaxy().getId());

            pointsService.savePoints(points);
            buildingService.saveBuilding(building);
            return "upgraded";
        } else {
            return "not enough points";
        }
    }
    public double getBuildingPrice(Building building) {
        int buildingTypePrice = building.getBuildingsType().buildingPrice;
        double costMultiplier = ConfigOperator.levelCostMultiplier * building.getBuildingLevel();
        return buildingTypePrice * costMultiplier;
    }
    /*public void updatePlanetIndustryPoints(int planetId, Building building) {
        Planet planet = planetService.getPlanetById(planetId);

        int gotIndustryPoints = planet.getIndustryPointsProduce();
        int addedPoints = building.getBuildingLevel()
    }*/
}
