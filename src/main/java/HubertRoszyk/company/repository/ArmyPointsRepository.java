package HubertRoszyk.company.repository;

import HubertRoszyk.company.entiti_class.ArmyPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmyPointsRepository extends JpaRepository<ArmyPoints, Integer> {
    public ArmyPoints findArmyPointsByPlanetId(int planetId);
}
