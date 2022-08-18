package HubertRoszyk.company;

import HubertRoszyk.company.configuration.ConfigOperator;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

//management
@SpringBootApplication
@RestController
@EnableJpaRepositories
public class Main {
    //TODO tests
    //TODO comments
    //TODO code refreshment

    //DONE TODO get points
    //DONE TODO zabespieczenie na budowanie na nieswoich planetach i na atak z nieswojej

    //DONE TODO battle time
    //TODO battle status
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        ConfigOperator configOperator = new ConfigOperator();

        SpringApplication.run(Main.class, args);
    }
}
