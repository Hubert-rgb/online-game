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
    //TODO zabespieczenia na null

    //TODO building controller bool
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        ConfigOperator configOperator = new ConfigOperator();

        SpringApplication.run(Main.class, args);
    }
}
