package HubertRoszyk.company.service;

import HubertRoszyk.company.entiti_class.Galaxy;
import HubertRoszyk.company.repository.GalaxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalaxyService {
    @Autowired
    GalaxyRepository galaxyRepository;

    public Galaxy saveGalaxy(Galaxy galaxy){
        return galaxyRepository.save(galaxy);
    }
    public List<Galaxy> getAllGalaxies() {
        return galaxyRepository.findAll();
    }
    public Galaxy getGalaxyById(int id) {
        return galaxyRepository.findById(id).orElse(null);
    }
}
