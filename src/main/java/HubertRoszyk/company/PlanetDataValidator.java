package HubertRoszyk.company;

import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.PlanetLocation;
import HubertRoszyk.company.configuration.ConfigOperator;

import java.util.ArrayList;
import java.util.List;

public class PlanetDataValidator {
    public static List<Planet> validatePlanetPositionInGalaxy(List<Planet> galaxy) { //może być mało wydajne przez wielokrotne powtarzanie i rekurencję
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
    private static PlanetLocation validatePlanetPosition(PlanetLocation previousPlanetLocation, PlanetLocation currentPlanetLocation) {
        final double distance = Math.sqrt(Math.multiplyExact((previousPlanetLocation.xLocation - currentPlanetLocation.xLocation), 2) + Math.multiplyExact((previousPlanetLocation.yLocation - currentPlanetLocation.yLocation), 2));

        if (distance < ConfigOperator.minDistanceBetweenPlanets) {

            PlanetLocation planetLocation = RandomDraw.locationDraw();
            validatePlanetPosition(previousPlanetLocation, planetLocation);

            return planetLocation;

        } else {
            return currentPlanetLocation;
        }
    }
}
