package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.EntitiClass.FactoryPoints;
import HubertRoszyk.company.EntitiClass.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class FactoryFactoryPointsRepositoryTest {
    @Autowired
    FactoryPointsRepository factoryPointsRepository;

    @Test
    void itShouldFindPointsByUserId() {
        //given
        User user = new User();
        Galaxy galaxy = new Galaxy();

        FactoryPoints factoryPoints = new FactoryPoints(user, galaxy);

        factoryPointsRepository.save(factoryPoints);

        //when
        Set<FactoryPoints> gotPoints = factoryPointsRepository.findPointsByUserId(user.getId());
        //then
        assertThat(gotPoints).contains(factoryPoints);
    }
    @Test
    void itShouldFindPointsByUserIdAndGalaxyId() {
        //given
        User user = new User();
        Galaxy galaxy = new Galaxy();

        FactoryPoints factoryPoints = new FactoryPoints(user, galaxy);

        factoryPointsRepository.save(factoryPoints);

        //when
        FactoryPoints gotFactoryPoints = factoryPointsRepository.findPointsByUserIdAndGalaxyId(user.getId(), galaxy.getId());

        //then
        assertThat(gotFactoryPoints).isEqualTo(factoryPoints);
    }
}