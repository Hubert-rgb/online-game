package HubertRoszyk.company.EntitiClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class FactoryPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factoryPointsId")
    private int id;

    private double industryPoints;
    private double sciencePoints;

    private double industryPointsIncome;
    private double sciencePointsIncome;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "galaxyId", referencedColumnName = "galaxyId")
    private Galaxy galaxy;

    public FactoryPoints(User user, Galaxy galaxy) {
        this.galaxy = galaxy;
        this.user = user;

        industryPoints = 0;
        sciencePoints = 0;
    }

    /*public void assignUser(User user) {
        this.user = user;
    }
    public void assignGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }*/
}
