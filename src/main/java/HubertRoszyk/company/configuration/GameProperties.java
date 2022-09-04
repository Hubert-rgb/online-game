package HubertRoszyk.company.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.annotation.AccessType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Getter
@Setter
@Configuration
@PropertySource("game.properties")
public class GameProperties {
   /* @Value("${galaxyNum}")
    private int galaxyNum;*/

    @Value("${websiteLink}")
    private String websiteLink;

    @Value("${planetsNum}")
    private int planetsNum;
    @Value("${randomVariablesSum}")
    private int randomVariablesSum;
    @Value("${planetsSizes}")
    private int planetsSizes;
    @Value("${period}")
    private int period;
    @Value("${minDistanceBetweenPlanets}")
    private int minDistanceBetweenPlanets;
    @Value("${speed}")
    private int speed;

    @Value("${levelCostMultiplier}")
    private double levelCostMultiplier;

}
