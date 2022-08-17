package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.ArmyPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmyPointsRepository extends JpaRepository<ArmyPoints, Integer> {
    @Query(value = "SELECT * FROM ARMY_POINTS WHERE planet_Id = :planetId", nativeQuery = true)
    public ArmyPoints findArmyPointsByPlanetId(
            @Param("planetId") Integer planetId
    );
}
