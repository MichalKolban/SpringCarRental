package pl.kolban.SpringCarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kolban.SpringCarRental.model.Car;
import pl.kolban.SpringCarRental.model.CarType;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {


    Car findCarByCarPlateNumber(String plateNumber);
    List<Car> findCarModelByCarType(CarType carType);
    Car findCarByCarId(Integer carId);
    List<Car> findCarModelByCarBrand(String carBrand);
    boolean existsByCarPlateNumber(String plateNumber);

    @Query(value = ALL_AVAILIABLE_CARS, nativeQuery = true)
    List<Car> findAllAvailableCars();

    @Query(value = ALL_AVAILIABLE_MODELS, nativeQuery = true)
    List<Car> findAllAvailableModels(String carBrand);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = UPDATE_CAR, nativeQuery = true)
    int updateCar(@Param("id") int id, @Param ("brand") String brand, @Param("model") String model, @Param("plateNumber") String plateNumber, @Param("carType") String carType);


    // === QUERIES ===

    String ALL_AVAILIABLE_CARS = " SELECT car_id, car_brand, car_model, car_plate_number, car_type FROM car_info WHERE car_id IN " +
            " (SELECT car_info_id FROM car_rent_details WHERE avaliable_to_rent = true) ";

    String ALL_AVAILIABLE_MODELS = "SELECT c.car_id, c.car_brand, c.car_model, c.car_plate_number, c.car_type FROM car_info c WHERE " +
            " c.car_brand = ?1 AND car_id IN (SELECT car_info_id FROM car_rent_details WHERE avaliable_to_rent = true)";

    String UPDATE_CAR = " UPDATE car_info c SET c.car_brand = :brand, c.car_model = :model, c.car_plate_number = :plateNumber, " +
            " c.car_type = :carType WHERE c.car_id = :id ";





}
