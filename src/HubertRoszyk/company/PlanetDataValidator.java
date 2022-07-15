package HubertRoszyk.company;

import HubertRoszyk.company.ClassToInstance.Planet;
import HubertRoszyk.company.ClassToInstance.PlanetLocation;

import java.util.ArrayList;
import java.util.List;

public class PlanetDataValidator {
    public static List<Planet> validatePlanetPositionInGalaxy(List<Planet> galaxy) { //może być mało wydajne przez wielokrotne powtarzanie i rekurencję
        List<Planet> validatedGalaxy = new ArrayList<>();
        validatedGalaxy.add(galaxy.get(0));

        for (int i = 1; i < galaxy.size(); i++) {
            PlanetLocation previousPlanetLocation = galaxy.get(i - 1).planetLocation;
            PlanetLocation currentPlanetLocation = galaxy.get(i).planetLocation;

            PlanetLocation validatePlanetLocation  = validatePlanetPosition(previousPlanetLocation, currentPlanetLocation);

            Planet validatedPlanet = galaxy.get(i);
            validatedPlanet.planetLocation = validatePlanetLocation;
            validatedGalaxy.add(validatedPlanet);
        }
        return validatedGalaxy;
    }
    private static PlanetLocation validatePlanetPosition(PlanetLocation previousPlanetLocation, PlanetLocation currentPlanetLocation) {
        final double distance = Math.sqrt(Math.multiplyExact((previousPlanetLocation.xPosition - currentPlanetLocation.xPosition), 2) + Math.multiplyExact((previousPlanetLocation.yPosition - currentPlanetLocation.yPosition), 2));

        if (distance < ConfigOperator.minDistanceBetweenPlanets) {

            PlanetLocation planetLocation = RandomDraw.locationDraw();
            validatePlanetPosition(previousPlanetLocation, planetLocation);

            return planetLocation;

        } else {
            return currentPlanetLocation;
        }
    }
}
