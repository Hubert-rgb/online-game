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
    //TODO code refreshment, building management

    /** battle time update*/
    //DONE TODO battle time
    //TODO battle status

    /** code review update*/
    //nie testowane
    //DONE TODO Config
    //TODO rest api naming
    //TODO repository function naming
    //TODO JACSON

    /** code debuging*/
    //TODO connecting to galaxy, user not asign (raz nie działało)
    //TODO time task return from battle manager
    //TODO CORS doesnt work
    //TODO zabezpieczenie na budowanie na nieswojej planecie problem z planet.getUser()
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        GameProperties configOperator = new GameProperties();

        SpringApplication.run(Main.class, args);
    }
}
