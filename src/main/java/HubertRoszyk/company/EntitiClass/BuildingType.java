package HubertRoszyk.company.EntitiClass;

import lombok.Getter;

@Getter
public enum BuildingType {
    INDUSTRY(11, 10, 2),
    SCIENCE(6, 20, 2),
    DEFENSE(4, 15, 1),
    ATTACK(4, 15, 2);

    private final int levelNums;
    private int buildingPrice;
    private int pointsProduces;
    BuildingType(int levelNums, int buildingPrice, int pointsProduces) {
        this.levelNums = levelNums;
        this.buildingPrice = buildingPrice;
        this.pointsProduces = pointsProduces;
    }
}
