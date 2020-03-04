package pl.kolban.SpringCarRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kolban.SpringCarRental.model.projections.CarPriceAvaliableToRent;
import pl.kolban.SpringCarRental.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class CarRentDetailsRequestController {


    CarService carService;

    @Autowired
    public CarRentDetailsRequestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/hello")               // to remove
    public String hello(){
        return "hello from crd request controller";
    }

    @GetMapping("/avaliable")
    public List<CarPriceAvaliableToRent> allAvaliablePriceCarList()  {
        List<CarPriceAvaliableToRent> listCarPriceAvaliableToRent = carService.allAvaliablePriceCarList();
        return listCarPriceAvaliableToRent;
    }




}
