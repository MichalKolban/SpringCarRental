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

    public List<CarModel> findCarsBasedOnBrand(String carBrand) {
        String carbrand = stringUtils.checkSring(carBrand);
        List<CarModel> carBrandList = carRepository.findCarModelByCarBrand(carbrand);
        return carBrandList;
    }

    public String addNewCar(CarModel carModel) {
        String plateNumber = stringUtils.checkSring(carModel.getCarPlateNumber());
        carModel.setCarBrand(carModel.getCarBrand().toUpperCase());
        boolean exists = carRepository.existsByCarPlateNumber(plateNumber);

        // check if carType match !!!

        if (!exists) {
            carRepository.save(carModel);
            return "car saved.";
        } else {
            log.info("CarService.addNewCar() : " + carModel);
            return "car with plateNumber " + plateNumber + " already exists";
        }
    }

    public List<CarModel> getAllAvaliableCars() {
        List<CarModel> avaliableCars = carRepository.findAllAvaliableCars();
        return avaliableCars;
    }

    public List<CarModel> getAllAvaliableModels(String model){
        String brand = stringUtils.checkSring(model);
        List<CarModel> avaliableModels = carRepository.findAllAvaliableModels(brand);
        return avaliableModels;
    }

    public String deleteCar(String plateNumber) {
        try {
            CarModel cartoDelete = findCarByPlateNumber(plateNumber);

            if (cartoDelete != null) {
                carRepository.delete(cartoDelete);
                return "car successfully deleted";
            } else {
                return "Car with plateNumber : " + plateNumber + " doesn't exists";
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            log.error("CarService.deleteCar() : " + e);
        }
        return "Car with plateNumber : " + plateNumber + " doesn't exists";
    }


    // == PRIVATE METHODS == //

    private CarTypeModel carTypeExists(String str) {
        for (CarTypeModel carObject : CarTypeModel.values()) {
            if (carObject.toString().equals(str)) {
                return carObject;
            }
        }
        log.info("Requested o carType= " + str);
        return null;
    }
}
