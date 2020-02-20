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
    public BigController(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    // list of all Cars
    @GetMapping("/all")
    public List<CarModel> allCars() {
        return carRepository.findAll();
    }

    // car object based on id
    @GetMapping("/all/{id}")
    public CarModel findCar(@PathVariable String id) {
        CarModel car = carService.findCar(id);
        return car;
    }

    // list of cars based on car brand
    @GetMapping("/all/brand/{carBrand}")
    public List<CarModel> findBrand(@PathVariable String carBrand){
        List<CarModel> carBrandList = carService.findCarsBasedOnBrand(carBrand);
        return carBrandList;
    }

    // car object based on plate number
    @GetMapping("/platenumber/{plateNumber}")
    public CarModel findCarPlateNumber(@PathVariable String plateNumber) {
        CarModel carModel = carService.findCarByPlateNumber(plateNumber);
        return carModel;
    }

    // list of cars based on carType
    @GetMapping("/type/{carType}")
    public List<CarModel> findCarsBasedOnType(@PathVariable String carType) {
        List<CarModel> carTypeList = carService.findCarsBasedOnType(carType);
        return carTypeList;
    }

    // add Car to repository
    @PostMapping("/add")
    public String addNewCar(@RequestBody CarModel carModel){
        String saved = carService.addNewCar(carModel);
        return saved;
    }

    // list of all avaliable cars
    @GetMapping("/avaliable/all")
    public List<CarModel> avaliable(){
        List<CarModel> avaliableCarsList = carService.getAllAvaliableCars();
        return avaliableCarsList;
    }

    // list of all avaliable cars based on brand
    @GetMapping("/avaliable/{brand}")
    public List<CarModel> avaliableModels(@PathVariable String brand) {
        List<CarModel> avaliableModelsList = carService.getAllAvaliableModels(brand);
        return avaliableModelsList;
    }

    // delete car based on plateNumber
    @DeleteMapping("/delete")
    public String deleteCar(@RequestBody CarModel carModel){
        String response = carService.deleteCar(carModel.getCarPlateNumber());
        return response;
    }

}
