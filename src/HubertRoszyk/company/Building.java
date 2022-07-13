package HubertRoszyk.company;

public class Building { // dane budynku, są zależmne od typu i poziomu
    BuildingsType buildingsType;
    int buildingLevel;
    double buildingPrice = buildingsType.buildingPrice * ConfigOperator.levelCostMultiplier;
    Building(BuildingsType buildingsType, int buildingLevel) {
        this.buildingsType = buildingsType;
        this.buildingLevel = buildingLevel;
    }
}
