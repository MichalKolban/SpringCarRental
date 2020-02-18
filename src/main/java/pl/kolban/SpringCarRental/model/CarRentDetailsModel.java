package pl.kolban.SpringCarRental.model;

import javax.persistence.*;

@Entity(name = "car_rent_details")
public class CarRentDetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_rent_details_id")
    private int carRentDetailsId;

    @OneToOne
    @JoinColumn(name = "car_info_id")
    private CarModel carInfoId;

    @Column(name = "cost_per_day")
    private Double costPerDay;

    @Column(name = "rent_start_date")
    private String rentStartDate;

    @Column(name = "rent_end_date")
    private String rentEndDate;

    @Column(name = "avaliable_to_rent")
    private boolean avaliableToRent;

//    @OneToOne
//    private Car car;


    public CarRentDetailsModel() {
    }

    public CarRentDetailsModel(double costPerDay, String rentStartDate, String rentEndDate, boolean avaliableToRent) {
        this.costPerDay = costPerDay;
        this.rentStartDate = rentStartDate;
        this.rentEndDate = rentEndDate;
        this.avaliableToRent = true;
    }

    public CarRentDetailsModel(CarRentDetailsModel carRentDetails) {
    }

    public int getCarRentDetailsId() {
        return carRentDetailsId;
    }

    public void setCarRentDetailsId(int carRentDetailsId) {
        this.carRentDetailsId = carRentDetailsId;
    }



    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public CarModel getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(CarModel carInfoId) {
        this.carInfoId = carInfoId;
    }

    @Override
    public String toString() {
        return "CarRentDetails{" +
                "carRentDetailsId=" + carRentDetailsId +
                ", costPerDay=" + costPerDay +
                ", rentStartDate='" + rentStartDate + '\'' +
                ", rentEndDate='" + rentEndDate + '\'' +
                '}';
    }

}
