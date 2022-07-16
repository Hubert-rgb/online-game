package HubertRoszyk.company.ClassToInstance;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Planet {
    public Planet(int id, int industryPointsMultiplier, int sciencePointsMultiplier, int size, PlanetLocation planetLocation, int industryPointsProduce, int sciencePointsProduce, int galaxyNum){
        this.id = id;
        this.industryPointsMultiplier = industryPointsMultiplier;
        this.sciencePointsMultiplier = sciencePointsMultiplier;
        this.size = size;
        this.planetLocation = planetLocation;
        this.industryPointsProduce = industryPointsProduce;
        this.sciencePointsProduce = sciencePointsProduce;
        this.galaxyNum = galaxyNum;
    }

    public int id,
            industryPointsMultiplier,
            sciencePointsMultiplier,
            size,
            galaxyNum; //przydałoby się coś rzeby nie dało się tego zmienić, może buildier pattern

    public int industryPointsProduce = 1,
            sciencePointsProduce = 1;

    public PlanetLocation planetLocation;
    public List<Integer> buildingList;
}
