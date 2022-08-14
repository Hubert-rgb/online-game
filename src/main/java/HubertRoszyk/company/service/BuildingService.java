package HubertRoszyk.company.service;

import HubertRoszyk.company.EntitiClass.Building;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.repository.BuildingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    BuildingRepository repository;

    public Building saveBuilding(Building building) {
        return repository.save(building);
    }
    public List<Building> saveBuildingsList(List<Building> buildings) {
        return repository.saveAll(buildings);
    }
    public List<Building> getBuildingsList() {
        return repository.findAll();
    }
    public Building getBuildingById(int id) {
        return repository.findById(id).orElse(null);
    }
    public void deleteBuilding() {
        repository.deleteAll();
        System.out.println("All Buildings deleted");
    }
}
