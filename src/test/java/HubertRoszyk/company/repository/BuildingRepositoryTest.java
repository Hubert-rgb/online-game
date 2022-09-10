package HubertRoszyk.company.repository;

import HubertRoszyk.company.entiti_class.Building;
import HubertRoszyk.company.entiti_class.BuildingType;
import HubertRoszyk.company.entiti_class.Planet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class BuildingRepositoryTest {
    @Autowired
    private BuildingRepository underTest;

    @Test
    void findAllBuildingsByPlanetId() {
        //given
        Planet planet = new Planet();
        Building building = new Building(BuildingType.INDUSTRY, planet);

        underTest.save(building);
        //when
        List<Building> gotBuilding = underTest.findBuildingByPlanetId(planet.getId());

        //then
        assertThat(gotBuilding).contains(building);
    }
}