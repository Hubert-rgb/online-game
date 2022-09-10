package HubertRoszyk.company.controller;

import HubertRoszyk.company.entiti_class.*;
import HubertRoszyk.company.PointGenerator;
import HubertRoszyk.company.service.ArmyPointsService;
import HubertRoszyk.company.service.PlanetService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/army-points-controller/planets/{planetId}")
    public ArmyPoints getArmyPoints(@PathVariable int planetId) {
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
