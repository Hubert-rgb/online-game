package HubertRoszyk.company.repository;

import HubertRoszyk.company.entiti_class.ArmyPoints;
import HubertRoszyk.company.entiti_class.Planet;
import HubertRoszyk.company.entiti_class.PlanetType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ArmyPointsRepositoryTest {
    @Autowired
    ArmyPointsRepository underTest;

    @Test
    void findArmyPointsByPlanetId() {
        //given
        Planet planet = new Planet(
                PlanetType.SMALL,
                2,
                3,
                4,
                123,
                1451
        );
        ArmyPoints armyPoints = new ArmyPoints(
                planet
        );

        underTest.save(armyPoints);
        //when
        ArmyPoints gotArmyPoints = underTest.findArmyPointsByPlanetId(planet.getId());
        //then
        assertThat(gotArmyPoints).isEqualTo(gotArmyPoints);
    }
}