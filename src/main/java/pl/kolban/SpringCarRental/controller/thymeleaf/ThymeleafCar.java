package pl.kolban.SpringCarRental.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kolban.SpringCarRental.model.Car;
import pl.kolban.SpringCarRental.model.projections.CarPriceAvaliableToRent;
import pl.kolban.SpringCarRental.repository.CarRepository;

import java.util.List;

@Controller
public class ThymeleafCar {

    CarRepository carRepository;

    @Autowired
    public ThymeleafCar(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/carbyid")
    public String getId(Model model){
        Car carbyId = carRepository.findCarByCarId(11);   // for now hard coded
        model.addAttribute("carbyid", carbyId);
        System.out.println(carbyId.toString());
        return "carbyid";
    }

    @GetMapping("/carcar")
    public String getIdTEST(@RequestParam String id, Model model){
        int idCar = Integer.valueOf(id);
        System.out.println("ID to :" + id);
        Car carbyId = carRepository.findCarByCarId(idCar);
        model.addAttribute("carbyid", carbyId);
        System.out.println(carbyId.toString());
        return "carbyid";
    }


    @GetMapping("/allCarList")
    public String getAllCars(Model model){
        List<Car> carList = carRepository.findAll();
        model.addAttribute("carList", carList);
        System.out.println(carList.toString());
        return "allCarList";
    }

    @GetMapping("/allPriceCarList")
    public String getAllPrice(Model model){
        List<CarPriceAvaliableToRent> carList = carRepository.findAllByAvaliableAndPrice();
        model.addAttribute("carList", carList);
        System.out.println(carList.toString());
        return "allPriceCarList";
    }

    @RequestMapping("/addnewcar")
    public String createNewCar(Model model){
        model.addAttribute("newcar", new Car());
        return "allCarList";
    }


    @PostMapping("/home")
    public String returnHome(){
        return "home";
    }

}
