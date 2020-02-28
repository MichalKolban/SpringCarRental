package pl.kolban.SpringCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kolban.SpringCarRental.model.Car;
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
        Car carbyId = carRepository.findCarByCarId(11);
        model.addAttribute("carbyid", carbyId);
        System.out.println(carbyId.toString());
        return "carbyid";
    }

//    @GetMapping("/allCarList")
//    public String getAll(Model model){
//        List<Car> carList = carRepository.findAll();
//        model.addAttribute("carbyid", carList);
//        System.out.println(carList.toString());
//        return "allCarList";
//    }

    //TEST
    @GetMapping("/allCarList")
    public String getAllTEST(Model model){
        List<Car> carList = carRepository.findAll();
        model.addAttribute("carbyid", carList);
        System.out.println(carList.toString());
        return "TEST";
    }

}
