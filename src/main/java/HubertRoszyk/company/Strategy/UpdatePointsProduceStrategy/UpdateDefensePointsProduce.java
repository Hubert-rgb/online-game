package HubertRoszyk.company.Strategy.UpdatePointsProduceStrategy;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.controller.ArmyPointsController;
import HubertRoszyk.company.service.PlanetService;

public class UpdateDefensePointsProduce implements UpdatePointsProduceStrategy {
    PlanetService planetService;
    ArmyPointsController armyPointsController;

    public UpdateDefensePointsProduce(PlanetService planetService, ArmyPointsController armyPointsController) {
        this.planetService = planetService;
        this.armyPointsController = armyPointsController;
    }

    @Override
    public void update(Building building) {
        Planet planet = planetService.getPlanetById(building.getPlanet().getId());

        int gotDefensePoints = planet.getDefensePointsProduce();
        int producesPoints = building.getBuildingType().getPointsProduces();

        int setDefensePoints = gotDefensePoints + producesPoints;
        planet.setDefensePointsProduce(setDefensePoints);

        planetService.savePlanet(planet);

        armyPointsController.getTotalDefenceIncome(building.getPlanet().getId());
    }
}
