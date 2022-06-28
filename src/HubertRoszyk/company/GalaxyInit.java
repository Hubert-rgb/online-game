package HubertRoszyk.company;

import java.util.*;

public class GalaxyInit {

    public GalaxyInit(int planetsNum, int randomVariablesSum){
        ListManager listManager = ListManager.getInstance();
        Random random = new Random();
        for(int i = 0; i < planetsNum; i++){
            int id = listManager.planets.size() + 1;
            int size = random.nextInt(3);
            size++;
            int localRandomVariablesSum = randomVariablesSum - size;

            int industryPointsMultiplier = random.nextInt(localRandomVariablesSum - 1) + 1;
            int sciencePointsMultiplier = localRandomVariablesSum - industryPointsMultiplier;

            int xLocation = random.nextInt(1920) + 1;
            int yLocation = random.nextInt(1080) + 1;
            //validator

            Planet planet = new Planet(id, industryPointsMultiplier,sciencePointsMultiplier, size, xLocation, yLocation);
            listManager.planets.add(planet);
        }
    }
}

