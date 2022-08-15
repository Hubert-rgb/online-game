package HubertRoszyk.company.Strategy;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateDefencePointsProduce implements UpdatePointsProduceStrategy {
    PlanetService planetService;

    public UpdateDefencePointsProduce(PlanetService planetService) {
        this.planetService = planetService;
    }

    @Override
    public void update(Building building) {
        Planet planet = planetService.getPlanetById(building.getPlanet().getId());

        int gotDefencePoints = planet.getDefencePointsProduce();
        int producesPoints = building.getBuildingType().getPointsProduces();

        int setDefencePoints = gotDefencePoints + producesPoints;
        planet.setDefencePointsProduce(setDefencePoints);

        planetService.savePlanet(planet);
    }
}
