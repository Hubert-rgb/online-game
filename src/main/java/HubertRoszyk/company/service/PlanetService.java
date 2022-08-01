package HubertRoszyk.company.service;

import HubertRoszyk.company.ConfigOperator;
import HubertRoszyk.company.EntitiClass.Planet;
import HubertRoszyk.company.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepository repository;


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

    public List<Planet> getPlanetByGalaxy(int galaxyId) {
        List<Planet> allPlanets = repository.findAll();

        List<Planet> galaxyPlanets = new ArrayList<>();

        for (Planet planet : allPlanets) {
            if (planet.getGalaxy().getId() == galaxyId) {
                galaxyPlanets.add(planet);
            }
        }
        if (galaxyPlanets.size() != ConfigOperator.planetsNum) {
            System.out.println("planeta się zgubiła");
            return null;
        } else {
            return galaxyPlanets;
        }
    }
}
