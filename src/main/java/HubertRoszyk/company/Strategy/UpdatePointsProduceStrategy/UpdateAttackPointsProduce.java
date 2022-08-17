package HubertRoszyk.company.Strategy.UpdatePointsProduceStrategy;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.controller.ArmyPointsController;
import HubertRoszyk.company.service.PlanetService;

public class UpdateAttackPointsProduce implements UpdatePointsProduceStrategy {
    PlanetService planetService;
    ArmyPointsController armyPointsController;

    public UpdateAttackPointsProduce(PlanetService planetService, ArmyPointsController armyPointsController) {
        this.planetService = planetService;
        this.armyPointsController = armyPointsController;
    }

    @Override
    public void update(Building building) {
        Planet planet = planetService.getPlanetById(building.getPlanet().getId());

        int gotAttackPoints = planet.getAttackPointsProduce();
        int producesPoints = building.getBuildingType().getPointsProduces();

        int setAttackPoints = gotAttackPoints + producesPoints;
        planet.setAttackPointsProduce(setAttackPoints);

        planetService.savePlanet(planet);

        armyPointsController.getTotalAttackIncome(building.getPlanet().getId());
    }
}
