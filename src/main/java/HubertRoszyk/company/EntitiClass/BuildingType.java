package HubertRoszyk.company.EntitiClass;

import lombok.Getter;

@Getter
public enum BuildingType {
    INDUSTRY_POINTS_FACTORY(11, 10, 2),
    SCIENCE_POINTS_FACTORY(6, 20, 2),
    DEFENCE(4, 15, 1),
    ARMY_BARRACKS(4, 15, 2);

    private final int levelNums;
    private int buildingPrice;
    private int pointsProduces;
    BuildingType(int levelNums, int buildingPrice, int pointsProduces) {
        this.levelNums = levelNums;
        this.buildingPrice = buildingPrice;
        this.pointsProduces = pointsProduces;
    }
}
