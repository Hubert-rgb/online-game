package HubertRoszyk.company.entiti_class;

import lombok.Getter;

@Getter
public enum PlanetType {
    SMALL(2, 4, 10),
    MEDIUM(3, 6, 15),
    BIG(4, 8, 20);

    private int maximalSize;
    private int randomVariablesSum;
    private int defaultDefencePoints;

    PlanetType(int maximalSize, int randomVariablesSum, int defaultDefencePoints) {
        this.maximalSize = maximalSize;
        this.randomVariablesSum = randomVariablesSum;
        this.defaultDefencePoints = defaultDefencePoints;
    }
}
