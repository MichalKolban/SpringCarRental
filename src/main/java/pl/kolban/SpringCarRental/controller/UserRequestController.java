package pl.kolban.SpringCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kolban.SpringCarRental.model.User;
import pl.kolban.SpringCarRental.repository.UserRepository;
import pl.kolban.SpringCarRental.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRequestController {

    UserRepository userRepository;
    UserService userService;

    @Autowired
    public UserRequestController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        User user = userService.findUserById(id);
        return user;
    }

//    @PostMapping
//    public User udpateUser(@RequestBody User user){
//        return null;
//    }



}
