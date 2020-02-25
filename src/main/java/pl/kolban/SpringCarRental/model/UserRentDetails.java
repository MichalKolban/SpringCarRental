package pl.kolban.SpringCarRental.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserRentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRentDetailsId;

    private int userId;

    private int carId;


}
