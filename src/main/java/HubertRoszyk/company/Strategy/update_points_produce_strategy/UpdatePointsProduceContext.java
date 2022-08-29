package HubertRoszyk.company.Strategy.update_points_produce_strategy;

import HubertRoszyk.company.entiti_class.Building;

public class UpdatePointsProduceContext {
    private UpdatePointsProduceStrategy strategy;

    public void setStrategy(UpdatePointsProduceStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Building building) {
        strategy.update(building);
    }
}
