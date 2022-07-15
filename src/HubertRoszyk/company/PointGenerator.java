package HubertRoszyk.company;

import HubertRoszyk.company.ClassToInstance.User;

import java.util.Timer;
import java.util.TimerTask;

public class PointGenerator {

    private static PointGenerator instance;
    public static PointGenerator getInstance(){
        if (instance == null){
            instance = new PointGenerator();
        }
        return instance;
    }
    public static void generatePoints() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ListManager listManager = ListManager.getInstance();
                for (User user: listManager.users) {
                    user.industryPoints += user.industryPointsIncome;
                    user.sciencePoints += user.sciencePointsIncome;
                }
                System.out.println(listManager.users.get(0).industryPoints + "i");
                System.out.println(listManager.users.get(0).sciencePoints + "s");
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, ConfigOperator.period);
    }
}
