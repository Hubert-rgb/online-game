package HubertRoszyk.company.Strategy.UpdatePointsProduceStrategy;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.service.PlanetService;

public class UpdateAttackPointsProduce implements UpdatePointsProduceStrategy {
    PlanetService planetService;

    public UpdateAttackPointsProduce(PlanetService planetService) {
        this.planetService = planetService;
    }

    @Override
    public void update(Building building) {
        Planet planet = planetService.getPlanetById(building.getPlanet().getId());

        int gotAttackPoints = planet.getAttackPointsProduce();
        int producesPoints = building.getBuildingType().getPointsProduces();

        int setAttackPoints = gotAttackPoints + producesPoints;
        planet.setAttackPointsProduce(setAttackPoints);

        planetService.savePlanet(planet);
    }
}
