package HubertRoszyk.company.EntitiClass;

import HubertRoszyk.company.configuration.ConfigOperator;
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
    private BuildingsType buildingsType;
    @NonNull
    private int buildingLevel;
    private int buildingPrice;

    @ManyToOne
    @JoinColumn(name = "planetId", referencedColumnName = "planetId")
    private Planet planet;

}
