package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.FactoryPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FactoryPointsRepository extends JpaRepository<FactoryPoints, Integer> {
    @Query(value = "SELECT * FROM FACTORY_POINTS WHERE user_Id = :userId", nativeQuery = true)
    Set<FactoryPoints> findPointsByUserId(
            @Param("userId") Integer userId
    );
    //List<Points> findPointsByUserIdAndGalaxyId(Integer galaxyId, Integer userId);
    @Query(value = "SELECT * FROM FACTORY_POINTS WHERE galaxy_Id = :galaxyId AND user_Id = :userId", nativeQuery = true)
    FactoryPoints findPointsByUserIdAndGalaxyId(
            @Param("userId") Integer userId,
            @Param("galaxyId") Integer galaxyId
    );
}
