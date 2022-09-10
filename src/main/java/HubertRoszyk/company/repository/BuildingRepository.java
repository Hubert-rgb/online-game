package HubertRoszyk.company.repository;

import HubertRoszyk.company.entiti_class.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    List<Building> findBuildingByPlanetId(int planetId);
}