package HubertRoszyk.company.Strategy.update_points_produce_strategy;

import HubertRoszyk.company.entiti_class.Building;
import HubertRoszyk.company.entiti_class.Planet;
import HubertRoszyk.company.controller.FactoryPointsController;
import HubertRoszyk.company.service.PlanetService;

public class UpdateIndustryPointsProduce implements UpdatePointsProduceStrategy {
    //@Autowired
    private PlanetService planetService;
    private final FactoryPointsController factoryPointsController;

    public UpdateIndustryPointsProduce(PlanetService planetService, FactoryPointsController factoryPointsController) {
        this.planetService = planetService;
        this.factoryPointsController = factoryPointsController;
    }

    @Override
    public void update(Building building) {
        Planet planet = planetService.getPlanetById(building.getPlanet().getId());

        int gotIndustryPoints = planet.getIndustryPointsProduce();
        int producesPoints = building.getBuildingType().getPointsProduces();

        int setIndustryPoints = gotIndustryPoints + producesPoints;
        planet.setIndustryPointsProduce(setIndustryPoints);

        planetService.savePlanet(planet);

        factoryPointsController.getTotalIndustryPointsIncome(building.getPlanet().getUser().getId(), building.getPlanet().getGalaxy().getId());
    }
}
