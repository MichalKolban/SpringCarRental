package pl.kolban.SpringCarRental.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kolban.SpringCarRental.repository.CarRepository;

@Controller
public class ThymeleafController {


    CarRepository carRepository;

    @Autowired
    public ThymeleafController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @GetMapping("/test")
    public String showPage(Model model, int id){

        model.addAttribute("data", carRepository.findAllAvailableCars());

        return "index";




    }

}
