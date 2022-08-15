package HubertRoszyk.company.Strategy;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateSciencePointsProduce implements UpdatePointsProduceStrategy {
    PlanetService planetService;

    public UpdateSciencePointsProduce(PlanetService planetService) {
        this.planetService = planetService;
    }

    @Override
    public void update(Building building) {
        Planet planet = planetService.getPlanetById(building.getPlanet().getId());

        int gotSciencePoints = planet.getSciencePointsProduce();
        int producesPoints = building.getBuildingType().getPointsProduces();

        int setSciencePoints = gotSciencePoints + producesPoints;
        planet.setSciencePointsProduce(setSciencePoints);

        planetService.savePlanet(planet);
    }
}
