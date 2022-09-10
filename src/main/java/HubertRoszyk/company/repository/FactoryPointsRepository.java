package HubertRoszyk.company.repository;

import HubertRoszyk.company.entiti_class.FactoryPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FactoryPointsRepository extends JpaRepository<FactoryPoints, Integer> {
    Set<FactoryPoints> findFactory_PointsByUserId(int userId);

    FactoryPoints findFactory_PointsByUserIdAndGalaxyId(int userId, int galaxyId);
}
