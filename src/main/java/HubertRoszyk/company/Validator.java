package HubertRoszyk.company;

import HubertRoszyk.company.entiti_class.Planet;
import HubertRoszyk.company.entiti_class.PlanetLocation;
import HubertRoszyk.company.configuration.GameProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Validator {
    @Autowired
    GameProperties gameProperties;

    public List<Planet> validatePlanetPositionInGalaxy(List<Planet> galaxy) { //może być mało wydajne przez wielokrotne powtarzanie i rekurencję
        List<Planet> validatedGalaxy = new ArrayList<>();
        validatedGalaxy.add(galaxy.get(0));

        for (int i = 1; i < galaxy.size(); i++) {
            PlanetLocation previousPlanetLocation = galaxy.get(i - 1).getPlanetLocation();
            PlanetLocation currentPlanetLocation = galaxy.get(i).getPlanetLocation();

            PlanetLocation validatePlanetLocation  = validatePlanetPosition(previousPlanetLocation, currentPlanetLocation);

            Planet validatedPlanet = galaxy.get(i);

            PlanetLocation planetLocation;
            planetLocation = validatedPlanet.getPlanetLocation();
            planetLocation = validatePlanetLocation;
            validatedPlanet.setPlanetLocation(planetLocation);

            validatedGalaxy.add(validatedPlanet);
        }
        return validatedGalaxy;
    }
    private  PlanetLocation validatePlanetPosition(PlanetLocation previousPlanetLocation, PlanetLocation currentPlanetLocation) {
        final double distance = Math.sqrt(Math.multiplyExact((previousPlanetLocation.xLocation - currentPlanetLocation.xLocation), 2) + Math.multiplyExact((previousPlanetLocation.yLocation - currentPlanetLocation.yLocation), 2));

        if (distance < gameProperties.getMinDistanceBetweenPlanets()) {

            PlanetLocation planetLocation = RandomDraw.locationDraw();
            validatePlanetPosition(previousPlanetLocation, planetLocation);

            return planetLocation;

        } else {
            return currentPlanetLocation;
        }
    }
    /*public Boolean enoughPointsCheck(Building building, Points points){
        double buildingPrice = building.getBuildingPrice();
        double gotIndustryPoints = points.getIndustryPoints();

        if(gotIndustryPoints >= buildingPrice ) {
            return true;
        } else {
            return false;
        }
    }
    public Boolean upgradedLevelCheck(Building building, Points points) {
        if(building.getBuildingLevel() < building.getBuildingsType().getLevelNums()) {
            return true;
        } else {
            return false;
        }
    }*/
}
