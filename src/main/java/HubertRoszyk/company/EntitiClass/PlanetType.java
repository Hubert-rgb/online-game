package HubertRoszyk.company.EntitiClass;

import lombok.Getter;

@Getter
public enum PlanetType {
    SMALL(2, 4),
    MEDIUM(3, 6),
    BIG(4, 8);

    private int maximalSize;
    private int randomVariablesSum;

    PlanetType(int maximalSize, int randomVariablesSum) {
        this.maximalSize = maximalSize;
        this.randomVariablesSum = randomVariablesSum;
    }
}
