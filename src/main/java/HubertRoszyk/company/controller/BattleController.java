package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.ArmyPoints;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.RandomDraw;
import HubertRoszyk.company.service.ArmyPointsService;
import HubertRoszyk.company.service.PlanetService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BattleController {
    @Autowired
    PlanetService planetService;

    @Autowired
    ArmyPointsService armyPointsService;

    @PostMapping("/battle")
    public String armyMovement(@RequestBody JSONObject jsonInput) {
        int attackPlanetId = (int) jsonInput.get("attackPlanetId");
        int defensePlanetId = (int) jsonInput.get("defensePlanetId");

        Planet attackPlanet = planetService.getPlanetById(attackPlanetId);
        Planet defensePlanet = planetService.getPlanetById(defensePlanetId);

        /*ArmyPoints attackArmyPoints = armyPointsService.getArmyPointsByPlanetId(attackPlanetId);
        ArmyPoints defenseArmyPoints = armyPointsService.getArmyPointsByPlanetId(defensePlanetId);

        double attackPoints = attackArmyPoints.getAttackPoints();
        double defensePoints = defenseArmyPoints.getDefensePoints();*/

        if (attackPlanet.getUser().equals(defensePlanet.getUser())) {
            return changeArmyPlanet(attackPlanetId, defensePlanetId);
        } else {
            return battle(attackPlanetId, defensePlanetId);
        }
    }

    public String changeArmyPlanet(int giverPlanetId, int receiverPlanetId) {
        ArmyPoints giverArmyPoints = armyPointsService.getArmyPointsByPlanetId(giverPlanetId);
        ArmyPoints receiverArmyPoints = armyPointsService.getArmyPointsByPlanetId(receiverPlanetId);

        double gotGiverAttackPoints = giverArmyPoints.getAttackPoints();
        double gotReceiverAttackPoints = receiverArmyPoints.getAttackPoints();

        double setGiverAttackPoints = 0;
        double setReceiverAttackPoints = gotReceiverAttackPoints + gotGiverAttackPoints;

        giverArmyPoints.setAttackPoints(setGiverAttackPoints);
        receiverArmyPoints.setAttackPoints(setReceiverAttackPoints);

        armyPointsService.saveArmyPoints(giverArmyPoints);
        armyPointsService.saveArmyPoints(receiverArmyPoints);

        return "army changed planet";
    }

    //@PostMapping("/battle")
    public String battle(int attackPlanetId, int defensePlanetId) {
        Planet attackPlanet = planetService.getPlanetById(attackPlanetId);
        Planet defensePlanet = planetService.getPlanetById(defensePlanetId);

        ArmyPoints attackArmyPoints = armyPointsService.getArmyPointsByPlanetId(attackPlanetId);
        ArmyPoints defenseArmyPoints = armyPointsService.getArmyPointsByPlanetId(defensePlanetId);

        double attackPoints = attackArmyPoints.getAttackPoints();
        double defensePoints = defenseArmyPoints.getDefensePoints();

        double battleMultiplier = RandomDraw.battleMultiplierDraw();

        double battleAttackPoints = attackPoints * battleMultiplier;
        double battleDefensePoints = defensePoints * 2;

        if (battleAttackPoints > battleDefensePoints) {
            defensePlanet.asignUser(attackPlanet.getUser());

            double setDefencePlanetAttackPoints = attackPoints - (defensePoints * 2);

            attackArmyPoints.setAttackPoints(0);
            defenseArmyPoints.setDefensePoints(0); //to chyba nie będzie za bardzo zrównoważone
            defenseArmyPoints.setAttackPoints(setDefencePlanetAttackPoints);

            armyPointsService.saveArmyPoints(attackArmyPoints);
            armyPointsService.saveArmyPoints(defenseArmyPoints);

            return "attack won";
        } else {
            double setDefencePoints =  defensePoints - (attackPoints / 2);
            defenseArmyPoints.setDefensePoints(setDefencePoints);

            attackArmyPoints.setAttackPoints(0);

            armyPointsService.saveArmyPoints(attackArmyPoints);
            armyPointsService.saveArmyPoints(defenseArmyPoints);

            return  "attack lost";
        }
    }
}
