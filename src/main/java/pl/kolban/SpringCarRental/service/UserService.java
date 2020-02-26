package pl.kolban.SpringCarRental.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kolban.SpringCarRental.model.Car;
import pl.kolban.SpringCarRental.model.User;
import pl.kolban.SpringCarRental.repository.UserRepository;

@Service
public class UserService {

    private final static Logger log = LoggerFactory.getLogger(CarService.class);

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(String id) {
        int idUser = Integer.valueOf(id);
        User userById = userRepository.findUserById(idUser);
        if (userById != null) {
            log.info("Requested user with id " + id);
            return userById;
        }
        log.info("Requested user with id " + id);
        return null;
    }


}
