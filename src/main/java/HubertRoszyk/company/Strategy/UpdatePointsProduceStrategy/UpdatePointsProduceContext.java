package HubertRoszyk.company.Strategy.UpdatePointsProduceStrategy;

import HubertRoszyk.company.EntitiClass.Building;

public class UpdatePointsProduceContext {
    private UpdatePointsProduceStrategy strategy;

    public void setStrategy(UpdatePointsProduceStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Building building) {
        strategy.update(building);
    }
}
