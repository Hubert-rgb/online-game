package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class PlanetRepositoryTest {
    @Autowired
    private PlanetRepository underTest;

    @Test
    void itShouldGetPlanetsByGalaxyId() {
        //given
        Planet planet = new Planet(
                2,
                3,
                4,
                123,
                1451
        );
        underTest.save(planet);
        //when
        Planet savedPlanet = underTest.save(planet);
        //then
        assertThat(savedPlanet).usingRecursiveComparison()
                .ignoringFields("planetId").isEqualTo(planet);
    }
    @Test
    void itShouldGetPlanetsByGalaxyId2() {
        Planet planet = new Planet(
                2,
                3,
                4,
                123,
                1451
        );
        underTest.save(planet);
        //planetRepository.save(planet);
        List<Planet> planets = underTest.findAllByGalaxyId(null);

        assertThat(planets).contains(planet);
    }
}