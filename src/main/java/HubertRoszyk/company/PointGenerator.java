package HubertRoszyk.company;

public class PointGenerator {

    private static PointGenerator instance;
    public static PointGenerator getInstance(){
        if (instance == null){
            instance = new PointGenerator();
        }
        return instance;
    }
    /*public static void generatePoints() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ListManager listManager = ListManager.getInstance();
                for (User user: listManager.users) {

                    int userIndustryPoints = user.getIndustryPoints();
                    int userSciencePoints = user.getSciencePoints();

                    userIndustryPoints += user.getIndustryPointsIncome();
                    userSciencePoints += user.getSciencePointsIncome();


                    user.setIndustryPoints(userIndustryPoints);
                    user.setSciencePoints(userSciencePoints);
                }
                System.out.println(listManager.users.get(0).getIndustryPoints() + "i");
                System.out.println(listManager.users.get(0).getSciencePoints() + "s");
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, ConfigOperator.period);
    }*/
}
