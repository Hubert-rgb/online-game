package HubertRoszyk.company.controller;

import HubertRoszyk.company.entiti_class.ArmyPoints;
import HubertRoszyk.company.entiti_class.Battle;
import HubertRoszyk.company.entiti_class.Planet;
import HubertRoszyk.company.RandomDraw;
import HubertRoszyk.company.configuration.GameProperties;
import HubertRoszyk.company.entiti_class.User;
import HubertRoszyk.company.service.ArmyPointsService;
import HubertRoszyk.company.service.BattleService;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class BattleController {
    @Autowired
    PlanetService planetService;

    @Autowired
    ArmyPointsService armyPointsService;

    @Autowired
    GameProperties gameProperties;

    @Autowired
    UserService userService;

    @Autowired
    BattleService battleService;

    @PostMapping("/battle-controller/battles")
    public String armyMovement(@RequestBody JSONObject jsonInput) {
        int userId = (int) jsonInput.get("userId");
        int attackPlanetId = (int) jsonInput.get("attackPlanetId");
        int defensePlanetId = (int) jsonInput.get("defensePlanetId");


        /*ArmyPoints attackArmyPoints = armyPointsService.getArmyPointsByPlanetId(attackPlanetId);
        ArmyPoints defenseArmyPoints = armyPointsService.getArmyPointsByPlanetId(defensePlanetId);

        double attackPoints = attackArmyPoints.getAttackPoints();
        double defensePoints = defenseArmyPoints.getDefensePoints();*/

        return sendArmy(userId, attackPlanetId, defensePlanetId);
    }

    public String executeArmyMovement(int userId, int attackPlanetId, int defensePlanetId, int battleId) {
        Planet attackPlanet = planetService.getPlanetById(attackPlanetId);
        Planet defensePlanet = planetService.getPlanetById(defensePlanetId);

        User attackPlanetUser = attackPlanet.getUser();

        Battle battle = battleService.getBattleById(battleId);

        if (attackPlanet.getUser().getId() == userId) {
            if (attackPlanet.getUser().equals(defensePlanet.getUser())) {
                return changeArmyPlanet(attackPlanetId, defensePlanetId, battleId);
            } else {
                return battle(attackPlanetId, defensePlanetId, battleId);
            }
        } else {
            battle.setStatus("not your planet");
            battleService.saveBattle(battle);
            return "not your planet";
        }
    }

    public String changeArmyPlanet(int giverPlanetId, int receiverPlanetId, int battleId) {
        Battle battle = battleService.getBattleById(battleId);

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

        battle.setStatus("army changed planet");
        battleService.saveBattle(battle);
        return "army changed planet";
    }

    //@PostMapping("/battle")
    public String battle(int attackPlanetId, int defensePlanetId, int battleId) {
        Battle battle = battleService.getBattleById(battleId);
        System.out.println(battle);
        System.out.println(battleId);

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

            battle.setStatus("attack won");
            battleService.saveBattle(battle);
            return "attack won";
        } else {
            double setDefencePoints =  defensePoints - (attackPoints / 2);
            defenseArmyPoints.setDefensePoints(setDefencePoints);

            attackArmyPoints.setAttackPoints(0);

            armyPointsService.saveArmyPoints(attackArmyPoints);
            armyPointsService.saveArmyPoints(defenseArmyPoints);

            battle.setStatus("attack lost");
            battleService.saveBattle(battle);
            return  "attack lost";
        }
    }

    public String sendArmy(int userId, int attackPlanetId, int defensePlanetId) {
        Planet attackPlanet = planetService.getPlanetById(attackPlanetId);
        Planet defensePlanet = planetService.getPlanetById(defensePlanetId);
        User user = userService.getUserById(userId);

        int distanceX = attackPlanet.getPlanetLocationX() - defensePlanet.getPlanetLocationX();
        int distanceY = attackPlanet.getPlanetLocationY() - defensePlanet.getPlanetLocationY();

        double distance = ((distanceX * distanceX) + (distanceY * distanceY)) ^ (1 / 2);
        int speed = gameProperties.getSpeed();
        long battleTime = (long) (distance / speed);

        String[] output = new String[1];

        System.out.println(battleTime);

        Battle battle = new Battle(attackPlanet, defensePlanet, user, battleTime);
        battleService.saveBattle(battle);

        int battleId = battle.getId();
        System.out.println(battleId);

        Timer timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("army moves");
                        output[0] = (executeArmyMovement(userId, attackPlanetId, defensePlanetId, battleId));
                        System.out.println("army moved");
                        //timer.cancel();
                    }
                },
                (battleTime)
        );
        System.out.println("output" + output[0]);

        return output[0];
    }
    /** geting battle status */
    @GetMapping("/battle-controller/battles/{battleId}/status")
    public String getBattleStatus(@PathVariable int battleId) {
        Battle battle = battleService.getBattleById(battleId);
        return battle.getStatus();
    }

    /** getting time left on battle*/
    @GetMapping("/battle-controller/battles/{battleId}/timeLeft")
    public long getBattleTimeLeft(@PathVariable int battleId) {
        LocalDateTime currentTime = LocalDateTime.now();

        Battle battle = battleService.getBattleById(battleId);
        LocalDateTime battleStartingTime = battle.getStartingTime();

        Duration battleDuration = Duration.between(battleStartingTime, currentTime);

        //battle time in nanoseconds
        long battleTimeLeft = battle.getBattleTime() - (battleDuration.getSeconds() * 1000);
        System.out.println(battle.getBattleTime());
        System.out.println(battleDuration.getNano());

        return battleTimeLeft;
    }
}
