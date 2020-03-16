package pl.kolban.SpringCarRental.model.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.kolban.SpringCarRental.model.CarType;

@JsonPropertyOrder({ "carId", "carBrand" , "carModel" , "carPlateNumber", "carType" ,"costPerDay", "avaliableToRent"})
public interface CarPriceAvaliableToRent {

    Integer getCarId();
    String getCarBrand();
    String getCarModel();
    String getCarPlateNumber();
    CarType getCarType();
    double getCostPerDay();
    boolean isAvaliableToRent();
}
