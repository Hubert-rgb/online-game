package HubertRoszyk.company.controller;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.Points;
import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.PointGenerator;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
public class PointsController {
    @Autowired
    private PointsService pointsService;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PointGenerator pointGenerator;

    public void createPoints(User user, Galaxy galaxy) {
        Points points = new Points(user, galaxy);
        pointsService.savePoints(points);

        //getTotalIndustryIncome(user.getId(), galaxy.getId());

        pointGenerator.generatePoints();
    }

    public void getTotalIndustryIncome(int userId, int galaxyId) {
        Points points = pointsService.getPointsByUserIdAndGalaxyId(userId, galaxyId);
        Set<Planet> userPlanets = planetService.getPlanetsByUserIdAndGalaxyId(userId, galaxyId);

        points.setIndustryPointsIncome(0);
        points.setSciencePointsIncome(0);

        int currentIndustryPointsIncome = 0;
        int currentSciencePointsIncome = 0;
        if (userPlanets != null) {
            for (Planet planet: userPlanets) {
                currentIndustryPointsIncome += planet.getIndustryPointsMultiplier() * planet.getIndustryPointsProduce();
                currentSciencePointsIncome += planet.getSciencePointsMultiplier() * planet.getSciencePointsProduce();
            }
        }
        points.setIndustryPointsIncome(currentIndustryPointsIncome);
        points.setSciencePointsIncome(currentSciencePointsIncome);

        pointsService.updatePoints(points);
    }
}
