package HubertRoszyk.company.entiti_class;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
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
    @Enumerated
    private PlanetType planetType;
    private int industryPointsMultiplier;
    private int sciencePointsMultiplier;
    private int defencePointsMultiplier = 1;
    private int attackPointsMultiplier = 1;

    private int size;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "galaxyId", referencedColumnName = "galaxyId")
    private Galaxy galaxy; //przydałoby się coś rzeby nie dało się tego zmienić, może buildier pattern

    private int industryPointsProduce = 1;
    private int sciencePointsProduce = 0;
    private int defensePointsProduce = 0;
    private int attackPointsProduce = 0;

    private int planetLocationX;
    private int planetLocationY;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Transient
    private PlanetLocation planetLocation;

    @JsonIgnore
    @OneToMany(mappedBy = "planet")
    private Set<Building> buildingList = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "planet")
    private ArmyPoints armyPoints;

    public Planet(PlanetType planetType, int industryPointsMultiplier, int sciencePointsMultiplier, int size, int xLocation, int yLocation) {
        this.industryPointsMultiplier = industryPointsMultiplier;
        this.sciencePointsMultiplier = sciencePointsMultiplier;
        this.planetLocationX = xLocation;
        this.planetLocationY = yLocation;
        this.size = size;
        this.planetType = planetType;

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
