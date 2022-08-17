package HubertRoszyk.company.EntitiClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

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

    private double defencePoints;
    private double attackPoints;

    private double defencePointsIncome;
    private double attackPointsIncome;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planet_id")
    private Planet planet;

    public ArmyPoints(Planet planet) {
        this.planet = planet;

        defencePoints = planet.getPlanetType().getDefaultDefencePoints();
        attackPoints = 0;

        defencePointsIncome = 0;
        attackPointsIncome = 0;
    }

}
