package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.*;
import HubertRoszyk.company.PointGenerator;
import HubertRoszyk.company.service.ArmyPointsService;
import HubertRoszyk.company.service.FactoryPointsService;
import HubertRoszyk.company.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
public class ArmyPointsController {
    @Autowired
    private ArmyPointsService armyPointsService;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PointGenerator pointGenerator;

    public void createArmyPoints(Planet planet) {
        ArmyPoints armyPoints = new ArmyPoints(planet);
        armyPointsService.saveArmyPoints(armyPoints);

        pointGenerator.generatePoints();
    }

    public void getTotalDefenceIncome(int planetId) {
        ArmyPoints armyPoints = armyPointsService.getArmyPointsByPlanetId(planetId);

        Planet planet = planetService.getPlanetById(planetId);

        int planetDefenceIncome = planet.getDefencePointsProduce() * planet.getDefencePointsMultiplier();

        armyPoints.setDefencePointsIncome(planetDefenceIncome);

        armyPointsService.saveArmyPoints(armyPoints);
    }
    public void getTotalAttackIncome(int planetId) {
        ArmyPoints armyPoints = armyPointsService.getArmyPointsByPlanetId(planetId);

        Planet planet = planetService.getPlanetById(planetId);

        int planetAttackPointsIncome = planet.getAttackPointsProduce() * planet.getAttackPointsMultiplier();

        armyPoints.setAttackPointsIncome(planetAttackPointsIncome);

        armyPointsService.saveArmyPoints(armyPoints);
    }
}
