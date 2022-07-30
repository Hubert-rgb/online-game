package HubertRoszyk.company;

import org.apache.catalina.connector.Response;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;


@SpringBootApplication
@RestController
public class Main {
    //TODO database managment
    //TODO binding users, planets and galaxies properly
    //TODO points entity [userId, galaxyId, points]
    //TODO przenieść punkty usera na osobną tablicę user galaxy
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        SpringApplication.run(Main.class, args);
        ConfigOperator configOperator = new ConfigOperator();

//        User user = new User(1, 0, 0, "Name", "Password", 0, 0);
//        UserService userService = new UserService();
//        userService.saveUser(user);
//        System.out.println("zapisano");
    }
}
