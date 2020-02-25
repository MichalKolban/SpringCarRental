package pl.kolban.SpringCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kolban.SpringCarRental.repository.CarRepository;
import pl.kolban.SpringCarRental.model.Car;
import pl.kolban.SpringCarRental.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarRequestController {

    CarRepository carRepository;
    CarService carService;

    @Autowired
    public CarRequestController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    // list of all Cars
    @GetMapping("/all")
    public List<Car> allCars() {
        return carRepository.findAll();
    }

    // car object based on id
    @GetMapping("/all/{id}")
    public Car findCar(@PathVariable String id) {
        Car car = carService.findCar(id);
        return car;
    }

    // list of cars based on car brand
    @GetMapping("/all/brand/{carBrand}")
    public List<Car> findBrand(@PathVariable String carBrand){
        List<Car> carBrandList = carService.findCarsBasedOnBrand(carBrand);
        return carBrandList;
    }

    // car object based on plate number
    @GetMapping("/platenumber/{plateNumber}")
    public Car findCarPlateNumber(@PathVariable String plateNumber) {
        Car car = carService.findCarByPlateNumber(plateNumber);
        return car;
    }

    // list of cars based on carType
    @GetMapping("/type/{carType}")
    public List<Car> findCarsBasedOnType(@PathVariable String carType) {
        List<Car> carTypeList = carService.findCarsBasedOnType(carType);
        return carTypeList;
    }

    // add Car to repository
    @PostMapping("/add")
    public String addNewCar(@RequestBody Car car){
        String saved = carService.addNewCar(car);
        return saved;
    }

    // list of all available cars
    @GetMapping("/available/all")
    public List<Car> avaliable(){
        List<Car> availableCarsList = carService.getAllAvailableCars();
        return availableCarsList;
    }

    // list of all available cars based on brand
    @GetMapping("/avaliable/{brand}")
    public List<Car> avaliableModels(@PathVariable String brand) {
        List<Car> avaliableModelsList = carService.getAllAvailableModels(brand);
        return avaliableModelsList;
    }

    // delete car based on plateNumber
    @DeleteMapping("/delete")
    public String deleteCar(@RequestBody Car car){
        String response = carService.deleteCar(car.getCarPlateNumber());
        return response;
    }

    // update Car parameters
    @PostMapping("/update")
    public String updateCarParameters(@RequestBody Car car){
        String updated = carService.updateCarParameters(car);
        return updated;
    }


}
