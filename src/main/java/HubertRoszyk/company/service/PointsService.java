package HubertRoszyk.company.service;

import HubertRoszyk.company.EntitiClass.Points;
import HubertRoszyk.company.PointGenerator;
import HubertRoszyk.company.repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PointsService {
    @Autowired
    PointsRepository repository;

    public List<Points> getPointsList() {
        return repository.findAll();
    }
    /*public Set<Points> getPointsByUserId(int userId) {
        return repository.findPointsByUserId(userId);
    }*/
    public Points savePoints(Points points) {
        return repository.save(points);
    }
    public List<Points> savePointsList(List<Points> points) {
        return repository.saveAll(points);
    }
    public void deleteAllPoints() {
        repository.deleteAll();
        System.out.println("usunięto wszystkie Punkty");
    }
    public Points getPointsByUserIdAndGalaxyId(int userId, int galaxyId) {
        return repository.findPointsByUserIdAndGalaxyId(userId, galaxyId);
    }
    public void updatePoints(Points points) {
        repository.deleteById(points.getId());
        repository.save(points);
    }
}
