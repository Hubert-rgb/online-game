package HubertRoszyk.company;

import HubertRoszyk.company.EntitiClass.Points;
import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.configuration.ConfigOperator;
import HubertRoszyk.company.service.PointsService;
import HubertRoszyk.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class PointGenerator {
    @Autowired
    PointsService pointsService;
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
                List<Points> pointsList = pointsService.getPointsList();
                System.out.println(pointsList);
                for (Points points: pointsList) {
                    double gotIndustryPoints = points.getIndustryPoints();
                    double gotSciencePoints = points.getSciencePoints();
                    double gotDefencePoints = points.getDefencePoints();
                    double gotAttackPoints = points.getAttackPoints();


                    double setIndustryPoints = gotIndustryPoints + points.getIndustryPointsIncome();
                    double setSciencePoints = gotSciencePoints + points.getSciencePointsIncome();
                    double setDefencePoints = gotDefencePoints + points.getDefencePointsIncome();
                    double setAttackPoints = gotAttackPoints + points.getAttackPointsIncome();

                    points.setIndustryPoints(setIndustryPoints);
                    points.setSciencePoints(setSciencePoints);
                    points.setDefencePoints(setDefencePoints);
                    points.setAttackPoints(setAttackPoints);

                    pointsService.updatePoints(points);
                }
                System.out.println("wygenerowano");
            }
        };
        Timer timer = new Timer();
        System.out.println(ConfigOperator.period);
        timer.schedule(task, 0, ConfigOperator.period);
    }
}
