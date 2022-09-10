package HubertRoszyk.company.service;

import HubertRoszyk.company.entiti_class.Battle;
import HubertRoszyk.company.entiti_class.Building;
import HubertRoszyk.company.repository.BattleRepository;
import HubertRoszyk.company.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService {
    @Autowired
    BattleRepository repository;

    public Battle saveBattle(Battle battle) {
        return repository.save(battle);
    }

    public List<Battle> saveBattlesList(List<Battle> battles) {
        return repository.saveAll(battles);
    }

    public List<Battle> getBattlesList() {
        return repository.findAll();
    }

    public Battle getBattleById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteBattle() {
        repository.deleteAll();
        System.out.println("All Battles deleted");
    }

    public List<Battle> getBattleByUserId(int userId) {
        return repository.findBattleByUserId(userId);
    }
}
