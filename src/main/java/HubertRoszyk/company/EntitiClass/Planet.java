package HubertRoszyk.company.EntitiClass;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Planet {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "planetId")
    private int id;
    @NonNull
    private int industryPointsMultiplier;
    @NonNull
    private int sciencePointsMultiplier;
    @NonNull
    private int size;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "galaxyId", referencedColumnName = "id")
    private Galaxy galaxy; //przydałoby się coś rzeby nie dało się tego zmienić, może buildier pattern

    @NonNull
    private int industryPointsProduce = 1;
    @NonNull
    private int sciencePointsProduce = 1;

    @NonNull
    private int planetLocationX;
    @NonNull
    private int planetLocationY;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Transient
    @NonNull
    private PlanetLocation planetLocation;
    @Transient
    private List<Integer> buildingList;

    public void asignUser(User user) {
        this.user = user;
    }

    public void asignGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }
}
