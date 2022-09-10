package HubertRoszyk.company.entiti_class;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Building { // dane budynku, są zależmne od typu i poziomu
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated
    @NonNull
    private BuildingType buildingType;
    private int buildingLevel = 0;
    //private int buildingPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @NonNull
    @JoinColumn(name = "planetId", referencedColumnName = "planetId")
    private Planet planet;

}
