package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.*;
import HubertRoszyk.company.PointGenerator;
import HubertRoszyk.company.service.ArmyPointsService;
import HubertRoszyk.company.service.PlanetService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ArmyPointsController {
    @Autowired
    private ArmyPointsService armyPointsService;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PointGenerator pointGenerator;

    @GetMapping("/getArmyPoints")
    public ArmyPoints getArmyPoints(@RequestBody JSONObject jsonInput) {
        int planetId = (int) jsonInput.get("planetId");
        ArmyPoints armyPoints = armyPointsService.getArmyPointsByPlanetId(planetId);

        return armyPoints;
    }

    public void getTotalDefenceIncome(int planetId) {
        ArmyPoints armyPoints = armyPointsService.getArmyPointsByPlanetId(planetId);

        Planet planet = planetService.getPlanetById(planetId);

        int planetDefenseIncome = planet.getDefensePointsProduce() * planet.getDefencePointsMultiplier();

        armyPoints.setDefensePointsIncome(planetDefenseIncome);

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
