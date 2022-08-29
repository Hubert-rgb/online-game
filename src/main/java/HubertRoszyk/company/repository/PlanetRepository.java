package HubertRoszyk.company.repository;

import HubertRoszyk.company.entiti_class.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {
    //@Query(value = "SELECT * FROM PLANET WHERE galaxy_Id = :galaxyId", nativeQuery = true)
    Set<Planet> getPlanetsByGalaxyId(
            @Param("galaxyId") Integer galaxyId
            );

    //@Query(value = "SELECT * FROM PLANET WHERE user_Id = :userId AND galaxy_Id = :galaxyId ", nativeQuery = true)
    Set<Planet> findAllUserPlanetsInGalaxy(
            @Param("userId") Integer userId,
            @Param("galaxyId") Integer galaxyId
    );
    //@Query(value = "SELECT * FROM PLANET WHERE user_Id = :userId", nativeQuery = true)
    Set<Planet> findByUserId(int planetId
            //@Param("userId") Integer planetId
    );
}
