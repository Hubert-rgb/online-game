package HubertRoszyk.company;

import HubertRoszyk.company.ClassToInstance.Planet;
import HubertRoszyk.company.ClassToInstance.User;
import HubertRoszyk.company.database.DatabasePlanetManager;
import HubertRoszyk.company.service.UserService;
import org.apache.catalina.connector.Response;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
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
        SpringApplication.run(Main.class, args);
        ConfigOperator configOperator = new ConfigOperator();

//        User user = new User(1, 0, 0, "Name", "Password", 0, 0);
//        UserService userService = new UserService();
//        userService.saveUser(user);
//        System.out.println("zapisano");
    }
    @PostMapping("/userMain")
    public static int loginUser(@RequestBody String user) throws IOException {
        System.out.println(user + "to jest z Main");
        return Response.SC_OK;
    }
}
