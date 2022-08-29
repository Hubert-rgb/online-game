package HubertRoszyk.company.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Getter
@Setter
@Configuration
@PropertySource("game.properties")
public class GameProperties {
    private int galaxyNum;

    private String websiteLink;

    private int planetsNum;
    private int randomVariablesSum;
    private int planetsSizes;
    private int period;
    private int minDistanceBetweenPlanets;
    private int speed;

    private double levelCostMultiplier;



    /*public GameProperties() throws IOException {
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
    }*/
}
