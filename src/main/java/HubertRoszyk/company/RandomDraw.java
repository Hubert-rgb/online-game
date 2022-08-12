package HubertRoszyk.company;

import HubertRoszyk.company.EntitiClass.PlanetLocation;

import java.util.Random;

public class RandomDraw {
    private static Random random = new Random();

    public static PlanetLocation locationDraw() {

        int xLocation = random.nextInt(1920) + 1;
        int yLocation = random.nextInt(1080) + 1;

        PlanetLocation planetLocation = new PlanetLocation(xLocation, yLocation);
        return planetLocation;
    }
    public static int sizeDraw() {
        int size;
        size = random.nextInt(3); //do config
        return size;
    }
    public static int industryPointsMultiplierDraw(int totalPoints) {
        int industryPointsMultiplier =  random.nextInt(totalPoints - 1) + 1;
        return industryPointsMultiplier;
    }
}
