package pl.kolban.SpringCarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kolban.SpringCarRental.model.CarModel;
import pl.kolban.SpringCarRental.model.CarTypeModel;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Integer> {


    List<CarModel> findCarModelByCarPlateNumber(String plateNumber);
    List<CarModel> findCarModelByCarType(CarTypeModel carType);

}
