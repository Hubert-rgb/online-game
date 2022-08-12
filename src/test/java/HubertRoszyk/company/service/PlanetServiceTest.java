package HubertRoszyk.company.service;

import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.repository.PlanetRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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
    void canSavePlanet() {
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
    void savePlanetsList() {
    }

    @Test
    void canGetPlanetsList() {
        //when
        underTest.getPlanetsList();
        //then
        verify(planetRepository).findAll();
    }

    @Test
    void getPlanetById() {
    }

    @Test
    void deletePlanets() {
    }

    @Test
    void updatePlanet() {
    }

    @Test
    @Disabled
    void getPlanetByGalaxy() {
    }
}