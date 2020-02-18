package pl.kolban.SpringCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kolban.SpringCarRental.repository.CarRepository;
import pl.kolban.SpringCarRental.model.CarModel;
import pl.kolban.SpringCarRental.model.CarTypeModel;
import pl.kolban.SpringCarRental.service.CarService;

import java.util.List;

@RestController
public class BigController {

    CarRepository blogRepository;

    CarTypeModel carTypeModel;

    CarService carService;

    @Autowired
    public BigController(CarRepository blogRepository, CarService carService) {
        this.blogRepository = blogRepository;
        this.carService = carService;
    }

//    @RequestMapping("/")
//    public String hello() {
//        return "Server started " + LocalTime.now();
//    }

    @GetMapping("/all")
    public List<CarModel> allCars() {
        return blogRepository.findAll();
    }


    @GetMapping("/all/{id}")
    public Object findCarById(@PathVariable String id){
        Object car = carService.findCar(id);
        return car;
    }

    @PostMapping("/test")
    public Object findCarById2(@RequestBody CarModel carModel){
        int idCar = carModel.getCarId();
        Object carId = blogRepository.findById(idCar);

        return carId;
    }

    @GetMapping("/plateNumber/{plateNumber}")
    public List<CarModel> findCarPlateNumber(@PathVariable String plateNumber) {
        List<CarModel> carList = blogRepository.findCarModelByCarPlateNumber(plateNumber);
        if (carList != null) {
            return carList;
        } else {
            return null;
        }
    }

    @GetMapping("car/{carType}")
    public List<CarModel> findCarByCarType(@PathVariable String carType) {
        carType = carType.toUpperCase();
        CarTypeModel model = (CarTypeModel) carTypeExists(carType);
        System.out.println(model.toString());
        System.out.println("Car exists");
        List<CarModel> carList = blogRepository.findCarModelByCarType(model);
        return carList;
    }

    @PostMapping("/test/type")
    public List<CarModel> findCarByCarTypeTest(@RequestBody CarModel carType) {
        CarTypeModel carType2 = carType.getCarType();
//        CarTypeModel model = (CarTypeModel) carTypeExists(carType);
        System.out.println(carType2.toString());
        System.out.println("Car exists");
        List<CarModel> carList = blogRepository.findCarModelByCarType(carType2);
        return carList;
    }



    private CarTypeModel carTypeExists(String str) {
        for (CarTypeModel carObject : CarTypeModel.values()) {
            if (carObject.toString().equals(str)) {
                return carObject;
            }
        }
        return null;
    }
}
