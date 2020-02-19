package pl.kolban.SpringCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kolban.SpringCarRental.repository.CarRepository;
import pl.kolban.SpringCarRental.model.CarModel;
import pl.kolban.SpringCarRental.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class BigController {

    CarRepository carRepository;
    CarService carService;

    @Autowired
    public BigController(CarRepository blogRepository, CarService carService) {
        this.carRepository = blogRepository;
        this.carService = carService;
    }

    // list of all Cars
    @GetMapping("/all")
    public List<CarModel> allCars() {
        return carRepository.findAll();
    }

    // car object based on id
    @GetMapping("/all/{id}")
    public CarModel findCarTEST(@PathVariable String id) {
        CarModel car = carService.findCar(id);
        return car;
    }

    // car object based on plate number
    @GetMapping("/platenumber/{plateNumber}")
    public CarModel findCarPlateNumberTEST(@PathVariable String plateNumber){
        CarModel carModel = carService.findCarByPlateNumber(plateNumber);
        return  carModel;
    }

    // list of cars based on carType
    @GetMapping("/type/{carType}")
    public List<CarModel> findCarsBasedOnType(@PathVariable String carType){
        List<CarModel> carTypeList =  carService.findCarsBasedOnType(carType);
        return carTypeList;
    }

}
