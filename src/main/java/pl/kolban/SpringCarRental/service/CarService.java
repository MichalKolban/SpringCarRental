package pl.kolban.SpringCarRental.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kolban.SpringCarRental.model.Car;
import pl.kolban.SpringCarRental.model.CarType;
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

//    public CarService() {
//
//    }

    public Car findCar(String id){
        int idCar = Integer.valueOf(id);
        Car carByCarId = carRepository.findCarByCarId(idCar);
        if(carByCarId != null){
            log.info("Requested car with id " + id);
            return carByCarId;
        } else {
            log.info("Requested car with id " + id);
            return null;
        }
    }

    public Car findCarByPlateNumber(String plateNumber) {
        String number = stringUtils.checkSring(plateNumber);
        Car carByCarPlateNumber = carRepository.findCarByCarPlateNumber(number);
        return carByCarPlateNumber;
    }

    public List<Car> findCarsBasedOnType(String carType) {
        String type = stringUtils.checkSring(carType);
        CarType carTypeModel = carTypeExistsObj(type);
        List<Car> carModelByCarType = carRepository.findCarModelByCarType(carTypeModel);
        return carModelByCarType;
    }

    public List<Car> findCarsBasedOnBrand(String carBrand) {
        String carbrand = stringUtils.checkSring(carBrand);
        List<Car> carBrandList = carRepository.findCarModelByCarBrand(carbrand);
        return carBrandList;
    }

    public String addNewCar(Car car) {
        String plateNumber = stringUtils.checkSring(car.getCarPlateNumber());
        car.setCarBrand(car.getCarBrand().toUpperCase());
        boolean exists = carRepository.existsByCarPlateNumber(plateNumber);

        // check if carType match !!!

        if (!exists) {
            carRepository.save(car);
            return "car saved.";
        } else {
            log.info("CarService.addNewCar() : " + car);
            return "car with plateNumber " + plateNumber + " already exists";
        }
    }

    public List<Car> getAllAvailableCars() {
        List<Car> availableCars = carRepository.findAllAvailableCars();
        return availableCars;
    }

    public List<Car> getAllAvailableModels(String model){
        String brand = stringUtils.checkSring(model);
        List<Car> availableModels = carRepository.findAllAvailableModels(brand);
        return availableModels;
    }

    public String deleteCar(String plateNumber) {
        try {
            Car cartoDelete = findCarByPlateNumber(plateNumber);

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

    public String updateCarParameters(Car car){

        String plateNumber = null;
        String brand = null;
        String model = null;
        String carType = null;

        Car oldCar = carRepository.findCarByCarId(car.getCarId());
        int id = car.getCarId();

        if(car.getCarPlateNumber() != null) {
            plateNumber = car.getCarPlateNumber();
            plateNumber = stringUtils.checkSring(plateNumber);
        }
        if(car.getCarBrand() != null) {
            brand = car.getCarBrand();
        }
        if(car.getCarModel() != null) {
            model = car.getCarModel();
        }
        if(car.getCarType() != null){
            String type = (car.getCarType().toString()).toUpperCase();
            carType = carTypeExist(type);
        }

        String updatePlateNumber = validateNewCarParameters(oldCar.getCarPlateNumber(), plateNumber);
        String updateCarBrand = validateNewCarParameters(oldCar.getCarBrand(), brand);
        String updateCarModel = validateNewCarParameters(oldCar.getCarModel(), model);
        String updateCarType = validateNewCarParameters(oldCar.getCarType().toString(), carType);

        int updateCar = carRepository.updateCar(id, updateCarBrand, updateCarModel, updatePlateNumber, updateCarType);

        if(updateCar != 0){
            return "Car updated.";
        }
        return null;
    }



    // == PRIVATE METHODS == //

    private String carTypeExist(String str){
        for (CarType carObject : CarType.values()) {
            if (carObject.toString().equals(str.toUpperCase())) {
                return carObject.toString();
            }
        }
        log.info("Requested o carType= " + str);
        return null;
    }

    private CarType carTypeExistsObj(String str) {
        for (CarType carObject : CarType.values()) {
            if (carObject.toString().equals(str.toUpperCase())) {
                return carObject;
            }
        }
        log.info("Requested o carType= " + str);
        return null;
    }


    private String validateNewCarParameters(String oldParameter, String updateParameter) {
        if (updateParameter != null) {
            if (!updateParameter.equals(oldParameter)) {
                return updateParameter;
            }
        }
        return oldParameter;
    }

}
