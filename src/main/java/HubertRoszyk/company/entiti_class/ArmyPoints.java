package HubertRoszyk.company.entiti_class;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class ArmyPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "armyPointsId")
    private int id;

    private double defensePoints;
    private double attackPoints;

    private double defensePointsIncome;
    private double attackPointsIncome;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planet_id")
    private Planet planet;

    public ArmyPoints(Planet planet) {
        this.planet = planet;

        defensePoints = planet.getPlanetType().getDefaultDefencePoints();
        attackPoints = 0;

        defensePointsIncome = 0;
        attackPointsIncome = 0;
    }

}
