package HubertRoszyk.company.database;

import HubertRoszyk.company.Planet;
import HubertRoszyk.company.PlanetLocation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabasePlanetManager {
    public static void addPlanetToDatabase(Planet planet) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement();

        String SQLInertionStatement = "INSERT INTO planets VALUES ( \"" + planet.id + "\", \"" + planet.industryPointsMultiplier + "\", \"" + planet.sciencePointsMultiplier + "\", \""
                + planet.size + "\", \"" + planet.planetLocation.xPosition + "\", \"" + planet.planetLocation.yPosition + "\", \"" + planet.industryPointsProduce + "\", \"" + planet.sciencePointsProduce + "\", \"" + planet.galaxyNum + "\")";
        statement.executeUpdate(SQLInertionStatement);
    }
    public static List<Planet> getPlanetsFromDatabase() throws SQLException {
        Connection connection = DatabaseConnection.connect();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        List<Planet> planets = new ArrayList<>();
        ResultSet planetsResultSet = statement.executeQuery("SELECT * FROM planets");

        int size = 0;
        planetsResultSet.beforeFirst();
        if (planetsResultSet.last()) {
            size = planetsResultSet.getRow();
            planetsResultSet.beforeFirst();
        }
        for (int i = 0; i < size; i++) {
            int id,
                    industryPointsMultiplier,
                    sciencePointsMultiplier,
                    planetSize,
                    xLocation,
                    yLocation,
                    galaxyNum,
                    industryPointsProduce,
                    sciencePointsProduce;


            planetsResultSet.next();

            id = planetsResultSet.getInt("idPlanets");
            industryPointsMultiplier = planetsResultSet.getInt("industryPointsMultiplier");
            sciencePointsMultiplier = planetsResultSet.getInt("sciencePointsMultiplier");
            planetSize = planetsResultSet.getInt("size");
            xLocation = planetsResultSet.getInt("xLocation");
            yLocation = planetsResultSet.getInt("yLocation");
            industryPointsProduce = planetsResultSet.getInt("industryPointsProduce");
            sciencePointsProduce = planetsResultSet.getInt("sciencePointsProduce");
            galaxyNum = planetsResultSet.getInt("galaxyNum");

            PlanetLocation planetLocation = new PlanetLocation(xLocation, yLocation);

            Planet planet = new Planet(id, industryPointsMultiplier, sciencePointsMultiplier, planetSize, planetLocation, industryPointsProduce, sciencePointsProduce, galaxyNum);

            planets.add(planet);
        }
        return planets;
    }
}
