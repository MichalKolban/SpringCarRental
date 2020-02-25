package pl.kolban.SpringCarRental.model;

import javax.persistence.*;

@Entity(name = "car_info")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;
    @Column(name = "car_brand", nullable = false)
    private String carBrand;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "car_plate_number", nullable = false)
    private String carPlateNumber;
    @Column(name = "car_type")
    @Enumerated(EnumType.STRING)
    public CarType carType;

    @OneToOne(mappedBy = "carInfoId", cascade = CascadeType.ALL)
    private CarRentDetails carRentDetails;

    public Car() {
    }

    public Car(String carBrand, String carModel, String carPlateNumber, CarType carType, CarRentDetails carRentDetails) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carPlateNumber = carPlateNumber;
        this.carType = carType;
        this.carRentDetails = new CarRentDetails(carRentDetails);
    }

    public Car(String carBrand, String carModel, String carPlateNumber, CarType carType) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carPlateNumber = carPlateNumber;
        this.carType = carType;
    }

    public int getCarId() {
        return carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carMark) {
        this.carBrand = carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carPlateNumber='" + carPlateNumber + '\'' +
                ", carMark='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carType=" + carType +
                '}';
    }

}
