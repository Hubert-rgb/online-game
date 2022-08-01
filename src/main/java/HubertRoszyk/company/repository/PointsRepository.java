package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PointsRepository extends JpaRepository<Points, Integer> {
    @Query(value = "SELECT * FROM POINTS WHERE user_Id = :userId", nativeQuery = true)
    Set<Points> findPointsByUserId(
            @Param("userId") Integer userId
    );
}
