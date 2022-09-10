package HubertRoszyk.company;

import HubertRoszyk.company.configuration.GameProperties;
import HubertRoszyk.company.configuration.WebConfigure;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

//management
@SpringBootApplication
@EnableJpaRepositories
@EntityScan()
public class Main {
    //TODO tests
    //TODO comments
    //TODO code refreshment, building management, battle management strategy

    /** battle time update*/
    //DONE TODO battle time doesn't work properly I guess
    //DONE TODO battle status
    //DONE TODO saving sending army start date and subtracting actual date\
    //DONE TODO separate table for battle with status (ongoing, won, lost)
    //DONE TODO get army status and time left

    /** code review update*/
    //DONE TODO Config
    //DONE TODO rest api naming. GET uri pathParam, POST JSON RequestBody
    //DONE TODO repository function naming
    //TODO JACSON

    /** code debuging*/
    //DONE TODO connecting to galaxy, user not asign (raz nie działało) can be postman issue, it's working almost every time
    //TODO not sure cors settings is working
    //DONE TODO check request types. I thing connectToGalaxy should be POST
    //DONE TODO zabezpieczenie na budowanie na nieswojej planecie problem z planet.getUser()
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        GameProperties configOperator = new GameProperties();

        SpringApplication.run(Main.class, args);
    }
}
