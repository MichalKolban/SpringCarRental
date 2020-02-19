package pl.kolban.SpringCarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kolban.SpringCarRental.model.CarModel;
import pl.kolban.SpringCarRental.model.CarTypeModel;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Integer> {


    CarModel findCarByCarPlateNumber(String plateNumber);
    List<CarModel> findCarModelByCarType(CarTypeModel carType);
    CarModel findCarByCarId(Integer carId);
    List<CarModel> findCarModelByCarBrand(String carBrand);
    boolean existsByCarPlateNumber(String plateNumber);


//    @Query("SELECT car_id, car_brand, car_model, car_plate_number, car_type FROM car_info WHERE car_id IN " +
//            " (SELECT car_info_id FROM car_rent_details WHERE avaliable_to_rent = true)")
//    List<CarModel> queryCarModelBy();

}
