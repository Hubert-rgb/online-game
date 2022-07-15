package HubertRoszyk.company.ClassToInstance;

import HubertRoszyk.company.ConfigOperator;

public class Building { // dane budynku, są zależmne od typu i poziomu
    public BuildingsType buildingsType;
    public int buildingLevel,
    id;

    public double buildingPrice;
    public void gerBuildingPrice() {
        buildingPrice = buildingsType.buildingPrice * ConfigOperator.levelCostMultiplier * buildingLevel;
    }
    public Building(int id, BuildingsType buildingsType, int buildingLevel) {
        this.id = id;
        this.buildingsType = buildingsType;
        this.buildingLevel = buildingLevel;
    }
}
