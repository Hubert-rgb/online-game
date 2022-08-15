package HubertRoszyk.company.Strategy.UpdatePointsProduceStrategy;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.service.PlanetService;

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
