package HubertRoszyk.company.repository;

import HubertRoszyk.company.entiti_class.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Integer> {
    List<Battle> findBattleByUserId(int userId);
}
