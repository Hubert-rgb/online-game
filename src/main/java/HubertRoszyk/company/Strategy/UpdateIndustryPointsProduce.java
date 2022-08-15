package HubertRoszyk.company.Strategy;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateIndustryPointsProduce implements UpdatePointsProduceStrategy {
    //@Autowired
    PlanetService planetService;

    public UpdateIndustryPointsProduce(PlanetService planetService) {
        this.planetService = planetService;
    }

    @Override
    public void update(Building building) {
        Planet planet = planetService.getPlanetById(building.getPlanet().getId());

        int gotIndustryPoints = planet.getIndustryPointsProduce();
        int producesPoints = building.getBuildingType().getPointsProduces();

        int setIndustryPoints = gotIndustryPoints + producesPoints;
        planet.setIndustryPointsProduce(setIndustryPoints);

        planetService.savePlanet(planet);
    }
}
