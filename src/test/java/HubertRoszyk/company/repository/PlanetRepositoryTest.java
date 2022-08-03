package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class PlanetRepositoryTest {
    @Autowired
    private PlanetRepository underTest;

    @Autowired
    private TestEntityManager entityManager;

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
        Galaxy galaxy = new Galaxy();
        planet.setGalaxy(galaxy);
        entityManager.persist(galaxy);
        entityManager.persist(planet);
        entityManager.flush();
        //when
        Set<Planet> savedPlanet = underTest.getPlanetsByGalaxyId(galaxy.getId());
        //then
        assertThat(savedPlanet).contains(planet);
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
        Set<Planet> planets = underTest.getPlanetsByGalaxyId(null);

        assertThat(planets).contains(planet);
    }
}