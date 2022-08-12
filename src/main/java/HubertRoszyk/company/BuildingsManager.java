package HubertRoszyk.company;

public class BuildingsManager { //dodaje, updatuje i usuwa budynki
    /*public static void addBuilding(int planetId, int userId, BuildingsType buildingsType) throws SQLException {
        Planet planet =  listManager.planets.get(planetId - 1);

        Building building = new Building(listManager.buildings.size() + 1 ,buildingsType, 1);

        List<Integer> buildingList = new ArrayList<>();
        buildingList = planet.getBuildingList();
        buildingList.add(building.id);
        planet.setBuildingList(buildingList);

        listManager.buildings.add(building);

        listManager.users.get(userId - 1).setIndustryPoints(
                listManager.users.get(userId - 1).getIndustryPoints() - building.buildingPrice
        );

        //listManager.updatePlanet(planetId - 1, planet);
        //add to db
    }*/
    /*public static void upgradeBuilding(int userId, int buildingId) {
        listManager.buildings.get(buildingId - 1).buildingLevel ++;

        listManager.users.get(userId - 1).setIndustryPoints(
                listManager.users.get(userId - 1).getIndustryPoints() - listManager.buildings.get(buildingId - 1).buildingPrice
        );
        //update in db
    }*/
}
