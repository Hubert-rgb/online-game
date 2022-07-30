package HubertRoszyk.company.EntitiClass;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
public class Planet {

    @Id
    @NonNull
    private final int id;
    private final int industryPointsMultiplier;
    private final int sciencePointsMultiplier;
    private final int size;
    private final int galaxyNum; //przydałoby się coś rzeby nie dało się tego zmienić, może buildier pattern

    @NonNull
    private int industryPointsProduce = 1;
    @NonNull
    private int sciencePointsProduce = 1;

    @NonNull
    private int planetLocationX;
    @NonNull
    private int planetLocationY;

    @Transient
    @NonNull
    private PlanetLocation planetLocation;
    @Transient
    private List<Integer> buildingList;
}
