package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

}
