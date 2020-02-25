package pl.kolban.SpringCarRental.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userinfo_id")
    private int userInfoId;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "city")
    private String city;

    public UserInfo() {
    }

    public UserInfo(int phoneNumber, String cardNumber, String city) {
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        this.city = city;
    }


    public int getUserInfoId() {
        return userInfoId;
    }

//    public void setUserInfoId(int userInfoId) {
//        this.userInfoId = userInfoId;
//    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userInfoId=" + userInfoId +
                ", phoneNumber=" + phoneNumber +
                ", cardNumber='" + cardNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
