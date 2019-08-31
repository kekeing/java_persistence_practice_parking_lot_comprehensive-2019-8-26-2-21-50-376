package tws.entity;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ParkingBoy {
    @NotBlank
    private int parkingboyId;

    @NotBlank(message = "用户名不能为空")
    private String parkingboyName;


    private int parkingboyAge;

    public ParkingBoy() {
    }

    public ParkingBoy(int parkingboyId, String parkingboyName, int parkingboyAge) {
        this.parkingboyId = parkingboyId;
        this.parkingboyName = parkingboyName;
        this.parkingboyAge = parkingboyAge;
    }

    public int getParkingboyId() {
        return parkingboyId;
    }

    public void setParkingboyId(int parkingboyId) {
        this.parkingboyId = parkingboyId;
    }

    public String getParkingboyName() {
        return parkingboyName;
    }

    public void setParkingboyName(String parkingboyName) {
        this.parkingboyName = parkingboyName;
    }

    public int getParkingboyAge() {
        return parkingboyAge;
    }

    public void setParkingboyAge(int parkingboyAge) {
        this.parkingboyAge = parkingboyAge;
    }

}
