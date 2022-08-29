package HubertRoszyk.company.service;

import HubertRoszyk.company.entiti_class.ArmyPoints;
import HubertRoszyk.company.repository.ArmyPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmyPointsService {
    @Autowired
    ArmyPointsRepository repository;

    public List<ArmyPoints> getArmyPointsList() {
        return repository.findAll();
    }
    /*public Set<Points> getPointsByUserId(int userId) {
        return repository.findPointsByUserId(userId);
    }*/
    public ArmyPoints saveArmyPoints(ArmyPoints armyPoints) {
        return repository.save(armyPoints);
    }
    public List<ArmyPoints> saveArmyPointsList(List<ArmyPoints> points) {
        return repository.saveAll(points);
    }
    public void deleteAllArmyPoints() {
        repository.deleteAll();
        System.out.println("usunięto wszystkie Punkty armii");
    }
    public ArmyPoints getArmyPointsByPlanetId(int planetId) {
        return repository.findArmyPointsByPlanetId(planetId);
    }
}
