package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.ArmyPoints;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.PlanetType;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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