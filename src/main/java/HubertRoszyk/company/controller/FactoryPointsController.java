package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.FactoryPoints;
import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.PointGenerator;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.FactoryPointsService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@Controller
@RestController
public class FactoryPointsController {
    @Autowired
    private FactoryPointsService factoryPointsService;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PointGenerator pointGenerator;

    @GetMapping("/getFactoryPoints")
    public FactoryPoints getFactoryPoints(@RequestBody JSONObject jsonInput) {
        int userId = (int) jsonInput.get("userId");
        int galaxyId = (int) jsonInput.get("galaxyId");

        FactoryPoints factoryPoints = factoryPointsService.getPointsByUserIdAndGalaxyId(userId, galaxyId);
        return factoryPoints;
    }

    public void createFactoryPoints(User user, Galaxy galaxy) {
        FactoryPoints factoryPoints = new FactoryPoints(user, galaxy);
        factoryPointsService.savePoints(factoryPoints);

        //getTotalFactoryIncome(user.getId(), galaxy.getId());

        pointGenerator.generatePoints();
    }

    public void getTotalIndustryPointsIncome(int userId, int galaxyId) {
        FactoryPoints factoryPoints = factoryPointsService.getPointsByUserIdAndGalaxyId(userId, galaxyId);
        Set<Planet> userPlanets = planetService.getPlanetsByUserIdAndGalaxyId(userId, galaxyId);

        factoryPoints.setIndustryPointsIncome(0);

        int currentIndustryPointsIncome = 0;
        if (userPlanets != null) {
            for (Planet planet: userPlanets) {
                currentIndustryPointsIncome += planet.getIndustryPointsMultiplier() * planet.getIndustryPointsProduce();
            }
        }
        factoryPoints.setIndustryPointsIncome(currentIndustryPointsIncome);

        factoryPointsService.updatePoints(factoryPoints);
    }
    public void getTotalSciencePointsIncome(int userId, int galaxyId) {
        FactoryPoints factoryPoints = factoryPointsService.getPointsByUserIdAndGalaxyId(userId, galaxyId);
        Set<Planet> userPlanets = planetService.getPlanetsByUserIdAndGalaxyId(userId, galaxyId);

        factoryPoints.setSciencePointsIncome(0);

        int currentSciencePointsIncome = 0;
        if (userPlanets != null) {
            for (Planet planet: userPlanets) {
                currentSciencePointsIncome += planet.getSciencePointsMultiplier() * planet.getSciencePointsProduce();
            }
        }
        factoryPoints.setSciencePointsIncome(currentSciencePointsIncome);

        factoryPointsService.updatePoints(factoryPoints);
    }
}
