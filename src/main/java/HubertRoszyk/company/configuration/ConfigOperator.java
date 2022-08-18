package HubertRoszyk.company.configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigOperator {
    public static int galaxyNum;
    public static String websiteLink;
    public static int planetsNum,
            randomVariablesSum,
            planetsSizes,
            period,
            minDistanceBetweenPlanets,
            speed;
    public static double levelCostMultiplier;
    public ConfigOperator() throws IOException {
        BufferedReader configReader = new BufferedReader(new FileReader("config.cfg"));
        websiteLink = configReader.readLine().split("=")[1];
        planetsNum = Integer.parseInt(configReader.readLine().split("=")[1]);
        randomVariablesSum = Integer.parseInt(configReader.readLine().split("=")[1]);
        planetsSizes = Integer.parseInt(configReader.readLine().split("=")[1]);
        period = Integer.parseInt(configReader.readLine().split("=")[1]);
        levelCostMultiplier = Double.parseDouble(configReader.readLine().split("=")[1]);
        minDistanceBetweenPlanets = Integer.parseInt(configReader.readLine().split("=")[1]);
        speed = Integer.parseInt(configReader.readLine().split("=")[1]);

        configReader.close();
        //System.out.println(websiteLink);
    }
}
