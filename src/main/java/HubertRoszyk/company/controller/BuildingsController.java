package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.*;
import HubertRoszyk.company.Strategy.*;
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
        String buildingsTypeString = (String) jsonInput.get("buildingType");

        System.out.println(buildingsTypeString);

        BuildingType buildingType = converter.convert(buildingsTypeString);

        Planet planet = planetService.getPlanetById(planetId);
        Points points = pointsService.getPointsByUserIdAndGalaxyId(userId, planet.getGalaxy().getId());

        Building building = new Building(buildingType, planet);

        return upgradeBuildingsLevelData(building, points);
    }
    @PostMapping("/upgradeBuilding")
    public String upgradeBuilding(@RequestBody JSONObject jsonInput) {
        int userId = (int) jsonInput.get("userId");
        int buildingId = (int) jsonInput.get("buildingId");

        Building building = buildingService.getBuildingById(buildingId);
        Points points = pointsService.getPointsByUserIdAndGalaxyId(userId, building.getPlanet().getGalaxy().getId());

        return upgradeBuildingsLevelData(building, points);
    }
    public double getBuildingPrice(Building building) {
        int buildingTypePrice = building.getBuildingType().getBuildingPrice();
        double costMultiplier = ConfigOperator.levelCostMultiplier * building.getBuildingLevel();
        return buildingTypePrice * costMultiplier;
    }
    public String upgradeBuildingsLevelData(Building building, Points points) {
        int gotBuildingLevel = building.getBuildingLevel();
        int setBuildingLevel = gotBuildingLevel + 1;

        building.setBuildingLevel(setBuildingLevel);

        double buildingPrice = getBuildingPrice(building);
        double gotIndustryPoints = points.getIndustryPoints();

        System.out.println("building Price = " + buildingPrice);
        System.out.println("Points = " + gotIndustryPoints);

        if (gotIndustryPoints >= buildingPrice && building.getBuildingLevel() < building.getBuildingType().getLevelNums() && building.getPlanet().getSize() > building.getPlanet().getBuildingList().size() + 2) {
            double setIndustryPoints = gotIndustryPoints - buildingPrice;
            points.setIndustryPoints(setIndustryPoints);

            updatePointsIncome(building);
            pointsController.getTotalIndustryIncome(points.getUser().getId(), building.getPlanet().getGalaxy().getId());

            pointsService.savePoints(points);
            buildingService.saveBuilding(building);
            return "upgraded";
        } else if (gotIndustryPoints < buildingPrice) {
            return "not enough points";
        } else if (building.getBuildingLevel() >= building.getBuildingType().getLevelNums()) {
            return "maximal level";
        } else if (building.getPlanet().getSize() <= building.getPlanet().getBuildingList().size()){
            return "not enough size";
        }
        return null;
    }
     /*public void updatePlanetIndustryPoints(Building building) {
        Planet planet = planetService.getPlanetById(building.getPlanet().getId());

        int gotIndustryPoints = planet.getIndustryPointsProduce();
        int producesPoints = building.getBuildingsType().getPointsProduces();

        int setIndustryPoints = gotIndustryPoints + producesPoints;
        planet.setIndustryPointsProduce(setIndustryPoints);

         planetService.savePlanet(planet);
     }*/
    public void updatePointsIncome(Building building) {
        UpdatePointsProduceContext context = new UpdatePointsProduceContext();

        switch (building.getBuildingType()) {
            case INDUSTRY_POINTS_FACTORY -> context.setStrategy(new UpdateIndustryPointsProduce(planetService));
            case SCIENCE_POINTS_FACTORY -> context.setStrategy(new UpdateSciencePointsProduce(planetService));
            case DEFENCE -> context.setStrategy(new UpdateDefencePointsProduce(planetService));
            case ARMY_BARRACKS -> context.setStrategy(new UpdateAttackPointsProduce(planetService));
        }
        context.executeStrategy(building);
    }
}
