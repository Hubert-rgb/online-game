package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.EntitiClass.PlanetLocation;
import HubertRoszyk.company.EntitiClass.User;
import HubertRoszyk.company.controller.GalaxyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlanetRepositoryTest {
    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private GalaxyRepository galaxyRepository;

    @Test
    void itShouldGetPlanetsByGalaxyId() {
        //given

        Planet planet = new Planet(
            1,
            2,
            3,
            1492,
            267
        );
        Galaxy galaxy = new Galaxy(
                0,
                "wspaniała"
        );
        User user = new User(
            "hubert",
            "masło"
        );

        planet.asignGalaxy(galaxy);
        planetRepository.save(planet);
        //when
        Set<Planet> gotPlanet = planetRepository.getPlanetsByGalaxyId(galaxy.getId());
        //then
        assertThat(gotPlanet)
                .isNotEmpty()
                .hasSize(1)
                .contains(planet);
    }
}