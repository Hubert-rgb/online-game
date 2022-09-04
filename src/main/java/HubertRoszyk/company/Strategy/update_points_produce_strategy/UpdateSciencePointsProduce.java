package HubertRoszyk.company.Strategy.update_points_produce_strategy;

import HubertRoszyk.company.entiti_class.Building;
import HubertRoszyk.company.entiti_class.Planet;
import HubertRoszyk.company.controller.FactoryPointsController;
import HubertRoszyk.company.service.PlanetService;

public class UpdateSciencePointsProduce implements UpdatePointsProduceStrategy {
    PlanetService planetService;
    FactoryPointsController factoryPointsController;

    public UpdateSciencePointsProduce(PlanetService planetService, FactoryPointsController factoryPointsController) {
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

        factoryPointsController.getTotalSciencePointsIncome(building.getPlanet().getUser().getId(), building.getPlanet().getGalaxy().getId());
    }
}