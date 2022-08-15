package HubertRoszyk.company.EntitiClass;

import HubertRoszyk.company.controller.PointsController;
import HubertRoszyk.company.service.PlanetService;
import HubertRoszyk.company.service.PointsService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Points {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pointsId")
    private int id;

    private double industryPoints;
    private double sciencePoints;
    private double defencePoints;
    private double attackPoints;

    private double industryPointsIncome;
    private double sciencePointsIncome;
    private double defencePointsIncome;
    private double attackPointsIncome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "galaxyId", referencedColumnName = "galaxyId")
    private Galaxy galaxy;

    public Points(User user, Galaxy galaxy) {
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
