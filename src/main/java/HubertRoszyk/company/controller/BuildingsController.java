package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.*;
import HubertRoszyk.company.Strategy.UpdatePointsProduceStrategy.*;
import HubertRoszyk.company.StringToBuildingsTypeConverter;
import HubertRoszyk.company.configuration.ConfigOperator;
import HubertRoszyk.company.service.BuildingService;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.FactoryPointsService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class BuildingsController { //dodaje, updatuje i usuwa budynki

    //musi updatować industry points i total industry points
    @Autowired
    BuildingService buildingService;

    @Autowired
    PlanetService planetService;

    @Autowired
    FactoryPointsController factoryPointsController;

    @Autowired
    ArmyPointsController armyPointsController;

    @Autowired
    FactoryPointsService factoryPointsService;

    @Autowired
    StringToBuildingsTypeConverter converter;

    @PostMapping("/addBuilding")
    public String addBuilding(@RequestBody JSONObject jsonInput) { //exception not string
        int planetId = (int) jsonInput.get("planetId");
        int userId = (int) jsonInput.get("userId");
        String buildingsTypeString = (String) jsonInput.get("buildingType");

        System.out.println(buildingsTypeString);

        BuildingType buildingType = converter.convert(buildingsTypeString);

        System.out.println(buildingType);

        Planet planet = planetService.getPlanetById(planetId);
        Set<Planet> usersPlanets = planetService.getPlanetsByUserId(userId);

        if (usersPlanets.contains(planet)) {
            Building building = new Building(buildingType, planet);

            return upgradeBuildingsLevelData(building);
        } else {
            return "not your planet";
        }
    }
    @PostMapping("/upgradeBuilding")
    public String upgradeBuilding(@RequestBody JSONObject jsonInput) {
        int userId = (int) jsonInput.get("userId");
        int buildingId = (int) jsonInput.get("buildingId");

        Building building = buildingService.getBuildingById(buildingId);
        Set<Planet> planets = planetService.getPlanetsByUserId(userId);

        if (planets.contains(building.getPlanet())) {
            return upgradeBuildingsLevelData(building);
        } else {
            return "not your planet";
        }
    }
    public double getBuildingPrice(Building building) {
        int buildingTypePrice = building.getBuildingType().getBuildingPrice();
        double costMultiplier = ConfigOperator.levelCostMultiplier * building.getBuildingLevel();
        return buildingTypePrice * costMultiplier;
    }
    public String upgradeBuildingsLevelData(Building building) {
        FactoryPoints factoryPoints = factoryPointsService.getPointsByUserIdAndGalaxyId(building.getPlanet().getUser().getId(), building.getPlanet().getGalaxy().getId());

        int gotBuildingLevel = building.getBuildingLevel();
        int setBuildingLevel = gotBuildingLevel + 1;

        building.setBuildingLevel(setBuildingLevel);

        double buildingPrice = getBuildingPrice(building);
        double gotIndustryPoints = factoryPoints.getIndustryPoints();

        System.out.println("building Price = " + buildingPrice);
        System.out.println("Points = " + gotIndustryPoints);

        boolean isEnoughPoints;
        boolean isNotOnMaximumLevel;
        boolean isEnoughSpaceOnPlanet;

        isEnoughPoints = gotIndustryPoints >= buildingPrice;
        isNotOnMaximumLevel = building.getBuildingLevel() < building.getBuildingType().getLevelNums();

        if(setBuildingLevel > 1) {
            isEnoughSpaceOnPlanet = true;
        } else {
            isEnoughSpaceOnPlanet = building.getPlanet().getSize() + 2 > building.getPlanet().getBuildingList().size();
        }

        if (isEnoughPoints && isNotOnMaximumLevel  && isEnoughSpaceOnPlanet) {  //strategy
            double setIndustryPoints = gotIndustryPoints - buildingPrice;
            factoryPoints.setIndustryPoints(setIndustryPoints);

            updatePointsIncome(building);

            factoryPointsService.savePoints(factoryPoints);
            buildingService.saveBuilding(building);
            return "upgraded";
        } else if (!isNotOnMaximumLevel) {
            return "maximal level";
        } else if (!isEnoughSpaceOnPlanet){
            return "not enough space";
        } else {
            return "not enough points";
        }
    }
    public void updatePointsIncome(Building building) {
        UpdatePointsProduceContext context = new UpdatePointsProduceContext();

        switch (building.getBuildingType()) {
            case INDUSTRY -> context.setStrategy(new UpdateIndustryPointsProduce(planetService, factoryPointsController));
            case SCIENCE -> context.setStrategy(new UpdateSciencePointsProduce(planetService, factoryPointsController));
            case DEFENSE -> context.setStrategy(new UpdateDefensePointsProduce(planetService, armyPointsController));
            case ATTACK -> context.setStrategy(new UpdateAttackPointsProduce(planetService, armyPointsController));
        }
        context.executeStrategy(building);
    }

    @GetMapping("/getBuildingList")
    public List<Building> getBuildingListOnPlanet(@RequestBody JSONObject jsonInput) {
        int planetId = (int) jsonInput.get("planetId");
        return buildingService.getBuildingsByPlanetId(planetId);
    }
}
