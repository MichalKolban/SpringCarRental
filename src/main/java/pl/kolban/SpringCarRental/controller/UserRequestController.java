package pl.kolban.SpringCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kolban.SpringCarRental.model.User;
import pl.kolban.SpringCarRental.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRequestController {

    UserRepository userRepository;

    @Autowired
    public UserRequestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }



}
