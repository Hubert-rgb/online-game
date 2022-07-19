package HubertRoszyk.company.repository;

import HubertRoszyk.company.ClassToInstance.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
