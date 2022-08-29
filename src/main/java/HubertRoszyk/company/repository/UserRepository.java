package HubertRoszyk.company.repository;

import HubertRoszyk.company.entiti_class.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
