package HubertRoszyk.company.repository;

import HubertRoszyk.company.EntitiClass.Galaxy;
import HubertRoszyk.company.EntitiClass.Points;
import HubertRoszyk.company.EntitiClass.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class PointsRepositoryTest {
    @Autowired
    PointsRepository pointsRepository;

    @Test
    void itShouldFindPointsByUserId() {
        //given
        User user = new User();
        Galaxy galaxy = new Galaxy();

        Points points = new Points(user, galaxy);

        pointsRepository.save(points);

        //when
        Set<Points> gotPoints = pointsRepository.findPointsByUserId(user.getId());
        //then
        assertThat(gotPoints).contains(points);
    }
    @Test
    void itShouldFindPointsByUserIdAndGalaxyId() {
        //given
        User user = new User();
        Galaxy galaxy = new Galaxy();

        Points points = new Points(user, galaxy);

        pointsRepository.save(points);

        //when
        Points gotPoints = pointsRepository.findPointsByUserIdAndGalaxyId(user.getId(), galaxy.getId());

        //then
        assertThat(gotPoints).isEqualTo(points);
    }
}