package HubertRoszyk.company.Strategy.update_points_produce_strategy;

import HubertRoszyk.company.entiti_class.Building;
import HubertRoszyk.company.entiti_class.Planet;
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
