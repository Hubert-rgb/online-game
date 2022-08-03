package HubertRoszyk.company.EntitiClass;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Planet {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planetId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int industryPointsMultiplier;
    private int sciencePointsMultiplier;
    private int size;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "galaxyId", referencedColumnName = "galaxyId")
    private Galaxy galaxy; //przydałoby się coś rzeby nie dało się tego zmienić, może buildier pattern

    private int industryPointsProduce = 1;
    private int sciencePointsProduce = 1;

    private int planetLocationX;
    private int planetLocationY;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Transient
    private PlanetLocation planetLocation;
    @Transient
    private List<Integer> buildingList;

    public Planet(int industryPointsMultiplier, int sciencePointsMultiplier, int size, int xLocation, int yLocation) {
        this.industryPointsMultiplier = industryPointsMultiplier;
        this.sciencePointsMultiplier = sciencePointsMultiplier;
        this.size = size;
        this.planetLocationX = xLocation;
        this.planetLocationY = yLocation;

        PlanetLocation location = new PlanetLocation(xLocation, yLocation);
        planetLocation = location;
    }

    public void asignUser(User user) {
        this.user = user;
    }

    public void asignGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }
}
