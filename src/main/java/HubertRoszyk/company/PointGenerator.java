package HubertRoszyk.company;

import HubertRoszyk.company.entiti_class.ArmyPoints;
import HubertRoszyk.company.entiti_class.FactoryPoints;
import HubertRoszyk.company.configuration.GameProperties;
import HubertRoszyk.company.service.ArmyPointsService;
import HubertRoszyk.company.service.FactoryPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class PointGenerator {
    @Autowired
    FactoryPointsService factoryPointsService;

    @Autowired
    ArmyPointsService armyPointsService;

    @Autowired
    GameProperties gameProperties;
    /*private static PointGenerator instance;
    public static PointGenerator getInstance(){
        if (instance == null){
            instance = new PointGenerator();
        }
        return instance;
    }*/
    //@EventListener(ApplicationReadyEvent.class)
    public void generatePoints() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<FactoryPoints> factoryPointsList = factoryPointsService.getPointsList();
                List<ArmyPoints> armyPointsList = armyPointsService.getArmyPointsList();
                for (FactoryPoints factoryPoints : factoryPointsList) {
                    double gotIndustryPoints = factoryPoints.getIndustryPoints();
                    double gotSciencePoints = factoryPoints.getSciencePoints();

                    double setIndustryPoints = gotIndustryPoints + factoryPoints.getIndustryPointsIncome();
                    double setSciencePoints = gotSciencePoints + factoryPoints.getSciencePointsIncome();

                    factoryPoints.setIndustryPoints(setIndustryPoints);
                    factoryPoints.setSciencePoints(setSciencePoints);

                    factoryPointsService.updatePoints(factoryPoints);
                }
                for (ArmyPoints armyPoints : armyPointsList) {
                    double gotDefencePoints = armyPoints.getDefensePoints();
                    double gotAttackPoints = armyPoints.getAttackPoints();

                    double setDefencePoints = gotDefencePoints + armyPoints.getDefensePointsIncome();
                    double setAttackPoints = gotAttackPoints + armyPoints.getAttackPointsIncome();

                    armyPoints.setDefensePoints(setDefencePoints);
                    armyPoints.setAttackPoints(setAttackPoints);

                    armyPointsService.saveArmyPoints(armyPoints);
                }
               // System.out.println("wygenerowano");
            }
        };
        Timer timer = new Timer();
        System.out.println(gameProperties.getPeriod());
        timer.schedule(task, 0, gameProperties.getPeriod());
    }
}
