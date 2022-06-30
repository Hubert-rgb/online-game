package HubertRoszyk.company;

public class Planet {
    public Planet(int id, int industryPointsMultiplier, int sciencePointsMultiplier, int size, int xLocation, int yLocation, int industryPointsProduce, int sciencePointsProduce, int galaxyNum){
        this.id = id;
        this.industryPointsMultiplier = industryPointsMultiplier;
        this.sciencePointsMultiplier = sciencePointsMultiplier;
        this.size = size;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.industryPointsProduce = industryPointsProduce;
        this.sciencePointsProduce = sciencePointsProduce;
        this.galaxyNum = galaxyNum;
    }
    public int id,
            industryPointsMultiplier,
            sciencePointsMultiplier,
            size,
            xLocation,
            yLocation,
            galaxyNum; //przydałoby się coś rzeby nie dało się tego zmienić, może buildier pattern
    public int industryPointsProduce = 1,
            sciencePointsProduce = 1;

}
