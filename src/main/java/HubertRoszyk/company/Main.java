package HubertRoszyk.company;

import HubertRoszyk.company.configuration.ConfigOperator;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;


@SpringBootApplication
@RestController
@EnableJpaRepositories
public class Main {
    //TODO getTotalIndustryIncome
    //TODO tests
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        SpringApplication.run(Main.class, args);
        ConfigOperator configOperator = new ConfigOperator();

        PointGenerator pointGenerator = PointGenerator.getInstance();
        pointGenerator.generatePoints();
    }
}
