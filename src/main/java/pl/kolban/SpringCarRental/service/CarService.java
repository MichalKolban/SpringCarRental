package pl.kolban.SpringCarRental.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kolban.SpringCarRental.model.CarModel;
import pl.kolban.SpringCarRental.model.CarTypeModel;
import pl.kolban.SpringCarRental.repository.CarRepository;
import pl.kolban.SpringCarRental.utils.StringUtils;

import java.util.List;


@Service
public class CarService {

    private final static Logger log = LoggerFactory.getLogger(CarService.class);

    CarRepository carRepository;
    StringUtils stringUtils;

    @Autowired
    public CarService(CarRepository carRepository, StringUtils stringUtils) {
        this.carRepository = carRepository;
        this.stringUtils = stringUtils;
    }

    public CarModel findCar(String id){
        int idCar = Integer.valueOf(id);
        CarModel carByCarId = carRepository.findCarByCarId(idCar);
        if(carByCarId != null){
            log.info("Requested car with id " + id);
            return carByCarId;
        } else {
            log.info("Requested car with id " + id);
            return null;
        }
    }

    public CarModel findCarByPlateNumber(String plateNumber) {
        String number = stringUtils.checkSring(plateNumber);
        CarModel carByCarPlateNumber = carRepository.findCarByCarPlateNumber(number);
        return carByCarPlateNumber;
    }

    public List<CarModel> findCarsBasedOnType(String carType) {
        String type = stringUtils.checkSring(carType);
        CarTypeModel carTypeModel = carTypeExists(type);
        List<CarModel> carModelByCarType = carRepository.findCarModelByCarType(carTypeModel);
        return carModelByCarType;
    }


    // == PRIVATE METHODS == //

    private CarTypeModel carTypeExists(String str) {
        for (CarTypeModel carObject : CarTypeModel.values()) {
            if (carObject.toString().equals(str)) {
                return carObject;
            }
        }
        return null;
    }

}
