package pl.kolban.SpringCarRental.model.projections;

import pl.kolban.SpringCarRental.model.CarType;

public interface CarPriceAvaliableToRent {

    Integer getCarId();
    String getCarBrand();
    String getCarModel();
    String getCarPlateNumber();
    CarType getCarType();
    double getCostPerDay();
    boolean isAvaliableToRent();
}
