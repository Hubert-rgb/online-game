package HubertRoszyk.company.service;

import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepository repository;

    public PlanetService(PlanetRepository planetRepository) {
        repository = planetRepository;
    }


    public Planet savePlanet(Planet planet) {
        return repository.save(planet);
    }
    public List<Planet> savePlanetsList(List<Planet> planets) {
        return repository.saveAll(planets);
    }
    public List<Planet> getPlanetsList() {
        return repository.findAll();
    }
    public Planet getPlanetById(int id) {
        return repository.findById(id).orElse(null);
    }
    public void deletePlanets() {
        repository.deleteAll();
        System.out.println("All Planets deleted");
    }
    public Planet updatePlanet(Planet planet) {
        Planet existingPlanet = repository.findById(planet.getId()).orElse(null);
        existingPlanet.setBuildingList(planet.getBuildingList());
        existingPlanet.setIndustryPointsProduce(planet.getIndustryPointsProduce());
        existingPlanet.setSciencePointsProduce(planet.getSciencePointsProduce());

        return repository.save(existingPlanet);
    }

    //to w repository trzeba zrobić
    public Set<Planet> getPlanetsByGalaxy(int galaxyId) {
        return repository.getPlanetsByGalaxyId(galaxyId);
    }

    public Set<Planet> getPlanetsByUserIdAndGalaxyId(int userId, int galaxyId) {
        return repository.findAllUserPlanetsInGalaxy(userId, galaxyId);
    }
    public Set<Planet> getPlanetsByUserId(int userId) {
        return repository.findAllPlanetsByUserId(userId);
    }
}
