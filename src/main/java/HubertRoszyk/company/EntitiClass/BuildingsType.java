package HubertRoszyk.company.EntitiClass;


public enum BuildingsType {
    INDUSTRY_POINTS_FACTORY(10, 10),
    SCIENCE_POINTS_FACTORY(5, 20),
    DEFENCE(3, 15),
    ARMY_BARRACKS(3, 15);

    final int levelNums,
    buildingPrice;
    BuildingsType(int levelNums, int buildingPrice) {
        this.levelNums = levelNums;
        this.buildingPrice = buildingPrice;
    }
}
