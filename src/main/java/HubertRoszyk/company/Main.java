package HubertRoszyk.company;

import HubertRoszyk.company.ClassToInstance.Planet;
import HubertRoszyk.company.ClassToInstance.User;
import HubertRoszyk.company.database.DatabasePlanetManager;
import org.apache.catalina.connector.Response;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    //TODO database managment
    //TODO binding users, planets and galaxies properly

    private static ListManager listManager = ListManager.getInstance();
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        SpringApplication.run( Main.class, args);
        DatabasePlanetManager.removePlanetData();
        ConfigOperator configOperator = new ConfigOperator();

        listManager.getDataFromDatabase();

/*        new GalaxyInit(ConfigOperator.planetsNum, ConfigOperator.randomVariablesSum);

        for (Planet planet :listManager.galaxies.get(listManager.galaxies.size() - 1)) {
            DatabasePlanetManager.addPlanetToDatabase(planet);
        }*/
    }
    @PostMapping("/userMain")
    public static int loginUser(@RequestBody String user) throws IOException {
        System.out.println(user + "to jest z Main");
        return Response.SC_OK;
    }
}
