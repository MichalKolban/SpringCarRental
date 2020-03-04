package pl.kolban.SpringCarRental.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kolban.SpringCarRental.model.Car;
import pl.kolban.SpringCarRental.model.CarType;
import pl.kolban.SpringCarRental.model.projections.CarPriceAvaliableToRent;
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

    public CarService() {
    }

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
        Car carByCarPlateNumber = null;
        try {
            String number = stringUtils.checkSring(plateNumber);
            carByCarPlateNumber = carRepository.findCarByCarPlateNumber(number);
            return carByCarPlateNumber;
        } catch (NullPointerException e) {
            log.error("CarService.findCarByPlateNumber : Requested plate number : " + plateNumber);
        }
        return null;
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

    public String updateCarParameters(Car car) {

        Car carFromDB = findCarByPlateNumber(car.getCarPlateNumber());
        if (carFromDB != null) {
            int id = carFromDB.getCarId();
            String plateNumber = stringUtils.checkSring(car.getCarPlateNumber());
            String brand = car.getCarBrand();
            String model = car.getCarModel();


            CarType updated;
            String updatedCarType = null;

            if(car.getCarType() != null){
                updated = carTypeExistsObj(car.getCarType().toString().toUpperCase());
                updatedCarType = updated.toString();
            }

            String updatePlateNumber = validateNewCarParameters(carFromDB.getCarPlateNumber(), plateNumber);
            String updateCarBrand = validateNewCarParameters(carFromDB.getCarBrand(), brand);
            String updateCarModel = validateNewCarParameters(carFromDB.getCarModel(), model);
            String updateCarType = validateNewCarParameters(carFromDB.getCarType().toString(), updatedCarType);

            int updateCar = carRepository.updateCar(id, updateCarBrand, updateCarModel, updatePlateNumber, updateCarType);

            if (updateCar != 0) {
                return "Car with id : " + carFromDB.getCarId() + " was updated.";
            }
        }
        log.info("CarService.updateCarParameters : requested for car with plate number " + car.getCarPlateNumber() + " who doesn't exists");
        return "plate number " + car.getCarPlateNumber() + " doesn't exists";
    }


    public List<CarPriceAvaliableToRent> allAvaliablePriceCarList() {

        List<CarPriceAvaliableToRent> allByAvaliablePrice = carRepository.findAllByAvaliableAndPrice();

        return allByAvaliablePrice;
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

    private boolean carTypeExistBools(String str){
        for (CarType carObject : CarType.values()) {
            if (carObject.toString().equals(str.toUpperCase())) {
                return true;
            }
        }
        log.error("Requested o carType= " + str);
        return false;
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
