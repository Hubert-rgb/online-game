package HubertRoszyk.company;

import HubertRoszyk.company.EntitiClass.Points;
import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.configuration.ConfigOperator;
import HubertRoszyk.company.service.PointsService;
import HubertRoszyk.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class PointGenerator {
    @Autowired
    PointsService pointsService;
    private static PointGenerator instance;
    public static PointGenerator getInstance(){
        if (instance == null){
            instance = new PointGenerator();
        }
        return instance;
    }
    public void generatePoints() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<Points> pointsList = pointsService.getPointsList();
                for (Points points: pointsList) {

                    int industryPoints = points.getIndustryPoints();
                    int sciencePoints = points.getSciencePoints();

                    industryPoints += points.getIndustryPointsIncome();
                    sciencePoints += points.getSciencePointsIncome();


                    points.setIndustryPoints(industryPoints);
                    points.setSciencePoints(sciencePoints);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, ConfigOperator.period);
    }
}
