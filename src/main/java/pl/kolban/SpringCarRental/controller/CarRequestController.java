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

    @GetMapping("/all")
    public List<Car> allCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car findCar(@PathVariable String id) {
        Car car = carService.findCar(id);
        return car;
    }

    @GetMapping("/brand/{carBrand}")
    public List<Car> findBrand(@PathVariable String carBrand){
        List<Car> carBrandList = carService.findCarsBasedOnBrand(carBrand);
        return carBrandList;
    }

    @GetMapping("/platenumber/{plateNumber}")
    public Car findCarPlateNumber(@PathVariable String plateNumber) {
        Car car = carService.findCarByPlateNumber(plateNumber);
        return car;
    }

    @GetMapping("/type/{carType}")
    public List<Car> findCarsBasedOnType(@PathVariable String carType) {
        List<Car> carTypeList = carService.findCarsBasedOnType(carType);
        return carTypeList;
    }

    @PostMapping("/add")
    public String addNewCar(@RequestBody Car car){
        String saved = carService.addNewCar(car);
        return saved;
    }

    @GetMapping("/available/all")
    public List<Car> avaliable(){
        List<Car> availableCarsList = carService.getAllAvailableCars();
        return availableCarsList;
    }

    @GetMapping("/avaliable/{brand}")
    public List<Car> avaliableModels(@PathVariable String brand) {
        List<Car> avaliableModelsList = carService.getAllAvailableModels(brand);
        return avaliableModelsList;
    }

    @DeleteMapping("/delete")
    public String deleteCar(@RequestBody Car car){
        String response = carService.deleteCar(car.getCarPlateNumber());
        return response;
    }

    @PostMapping("/update")
    public String updateCarParameters(@RequestBody Car car){
        String updated = carService.updateCarParameters(car);
        return updated;
    }

}
