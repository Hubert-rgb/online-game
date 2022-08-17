package HubertRoszyk.company.service;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.BuildingType;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.repository.BuildingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@ExtendWith(MockitoExtension.class)
class BuildingServiceTest {
    @Mock
    private BuildingRepository buildingRepository;
    private BuildingService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BuildingService(buildingRepository);
    }

    @Test
    void saveBuilding() {
    }

    @Test
    void saveBuildingsList() {
    }

    @Test
    void getBuildingsList() {
    }

    @Test
    void getBuildingById() {
    }

    @Test
    void deleteBuilding() {
    }

    @Test
    void getBuildingsByPlanetId() {
        //given
        Planet planet = new Planet();
        Building building = new Building(
                BuildingType.INDUSTRY,
                planet
        );
        //when
        List<Building> gotBuilding = underTest.getBuildingsByPlanetId(planet.getId());
        //then
        assertThat(gotBuilding).isEqualTo(building);
    }
}