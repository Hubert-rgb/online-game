package HubertRoszyk.company.service;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.repository.PlanetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {
    @Mock
    private PlanetRepository planetRepository;
    private PlanetService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PlanetService(planetRepository);
    }

    @Test
    void shouldSavePlanet() {
        //given
        Planet planet = new Planet(
                1,
                2,
                3,
                1492,
                267
        );
        //when
        underTest.savePlanet(planet);
        //then
        ArgumentCaptor<Planet> planetArgumentCaptor = ArgumentCaptor.forClass(Planet.class);
        verify(planetRepository).save(planetArgumentCaptor.capture());

        Planet capturedPlanet = planetArgumentCaptor.getValue();
        assertThat(capturedPlanet).isEqualTo(planet);
    }

    @Test
    void shouldSavePlanetsList() {
        //given
        Planet planet = new Planet(
                1,
                2,
                3,
                1492,
                267
        );
        Planet planet2 = new Planet(
                2,
                2,
                2,
                567,
                223
        );
        List<Planet> planetList = new ArrayList<>();

        //when
        underTest.savePlanetsList(planetList);
        //then
        ArgumentCaptor<List<Planet>> planetArgumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(planetRepository).saveAll(planetArgumentCaptor.capture());

        List<Planet> capturedPlanet = planetArgumentCaptor.getValue();
        assertThat(capturedPlanet).isEqualTo(planetList);
    }

    @Test
    void shouldGetPlanetsList() {
        //given
        Planet planet = new Planet(
                1,
                2,
                3,
                1492,
                267
        );
        Planet planet2 = new Planet(
                2,
                2,
                2,
                567,
                223
        );
        List<Planet> planetList = new ArrayList<>();

        underTest.savePlanetsList(planetList);
        //when
        List<Planet> gotPlanets = underTest.getPlanetsList();
        //then
        assertThat(gotPlanets).isEqualTo(planetList);
    }

    @Test
    void shouldGetPlanetById() {
        //given
        Planet planet = new Planet(
                1,
                2,
                3,
                1492,
                267
        );

        underTest.savePlanet(planet);
        //when
        System.out.println(planet.getId());
        Planet gotPlanet = underTest.getPlanetById(planet.getId());
        //then
        assertThat(gotPlanet).isEqualTo(planet);
    }

    @Test
    @Disabled
    void shouldDeletePlanets() {

    }

    @Test
    @Disabled
    void updatePlanet() {
    }

    @Test
    void shouldGetPlanetByGalaxy() {
        //given
        Planet planet = new Planet(
                1,
                2,
                3,
                1492,
                267
        );
        Galaxy galaxy = new Galaxy();

        planet.setGalaxy(galaxy);

        underTest.savePlanet(planet);

        //when
        Set<Planet> gotPlanets = underTest.getPlanetByGalaxy(galaxy.getId());

        //then
        assertThat(gotPlanets).isEqualTo(planet);
    }
}