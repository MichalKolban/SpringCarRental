package pl.kolban.SpringCarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kolban.SpringCarRental.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

        User findUserById(Integer id);

}
