package HubertRoszyk.company.Strategy.UpdatePointsProduceStrategy;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.controller.ArmyPointsController;
import HubertRoszyk.company.service.PlanetService;

public class UpdateDefencePointsProduce implements UpdatePointsProduceStrategy {
    PlanetService planetService;
    ArmyPointsController armyPointsController;

    public UpdateDefencePointsProduce(PlanetService planetService, ArmyPointsController armyPointsController) {
        this.planetService = planetService;
        this.armyPointsController = armyPointsController;
    }

    @Override
    public void update(Building building) {
        Planet planet = planetService.getPlanetById(building.getPlanet().getId());

        int gotDefencePoints = planet.getDefencePointsProduce();
        int producesPoints = building.getBuildingType().getPointsProduces();

        int setDefencePoints = gotDefencePoints + producesPoints;
        planet.setDefencePointsProduce(setDefencePoints);

        planetService.savePlanet(planet);

        armyPointsController.getTotalDefenceIncome(building.getPlanet().getId());
    }
}
