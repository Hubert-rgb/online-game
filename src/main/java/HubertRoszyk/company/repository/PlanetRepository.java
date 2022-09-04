package HubertRoszyk.company.repository;

import HubertRoszyk.company.entiti_class.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {
    Set<Planet> findByGalaxyId(int galaxyId);
    Set<Planet> findByUserIdAndGalaxyId(
            int userId,
            int galaxyId
    );
    Set<Planet> findByUserId(int planetId);
}
