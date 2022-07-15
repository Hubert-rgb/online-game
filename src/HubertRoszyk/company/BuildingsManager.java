package HubertRoszyk.company;

import HubertRoszyk.company.ClassToInstance.Building;
import HubertRoszyk.company.ClassToInstance.BuildingsType;
import HubertRoszyk.company.ClassToInstance.Planet;

import java.sql.SQLException;

public class BuildingsManager { //dodaje, updatuje i usuwa budynki
    private static ListManager listManager = ListManager.getInstance();
    public static void addBuilding(int planetId, int userId, BuildingsType buildingsType) throws SQLException {
        Planet planet =  listManager.planets.get(planetId - 1);

        Building building = new Building(listManager.buildings.size() + 1 ,buildingsType, 1);
        planet.buildingList.add(building.id);
        listManager.buildings.add(building);

        listManager.users.get(userId - 1).industryPoints -= building.buildingPrice;

        listManager.updatePlanet(planetId - 1, planet);
        //add to db
    }
    public static void upgradeBuilding(int userId, int buildingId) {
        listManager.buildings.get(buildingId - 1).buildingLevel ++;

        listManager.users.get(userId - 1).industryPoints -= listManager.buildings.get(buildingId - 1).buildingPrice;
        //update in db
    }
}
