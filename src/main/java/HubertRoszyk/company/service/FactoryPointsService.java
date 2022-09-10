package HubertRoszyk.company.service;

import HubertRoszyk.company.entiti_class.FactoryPoints;
import HubertRoszyk.company.repository.FactoryPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryPointsService {
    @Autowired
    FactoryPointsRepository repository;

    public List<FactoryPoints> getPointsList() {
        return repository.findAll();
    }
    /*public Set<Points> getPointsByUserId(int userId) {
        return repository.findPointsByUserId(userId);
    }*/
    public FactoryPoints savePoints(FactoryPoints factoryPoints) {
        return repository.save(factoryPoints);
    }
    public List<FactoryPoints> savePointsList(List<FactoryPoints> points) {
        return repository.saveAll(points);
    }
    public void deleteAllPoints() {
        repository.deleteAll();
        System.out.println("usunięto wszystkie Punkty");
    }
    public FactoryPoints getPointsByUserIdAndGalaxyId(int userId, int galaxyId) {
        return repository.findFactory_PointsByUserIdAndGalaxyId(userId, galaxyId);
    }
    public void updatePoints(FactoryPoints factoryPoints) {
        //repository.deleteById(points.getId());
        repository.save(factoryPoints);
    }
}
