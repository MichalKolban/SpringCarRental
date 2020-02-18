package pl.kolban.SpringCarRental;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kolban.SpringCarRental.model.CarModel;
import pl.kolban.SpringCarRental.model.CarTypeModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<CarModel, Integer> {


    List<CarModel> findCarModelByCarPlateNumber(String plateNumber);

    List<CarModel> findCarModelByCarType(CarTypeModel carType);

}
