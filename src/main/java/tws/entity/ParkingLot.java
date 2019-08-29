package tws.entity;

public class ParkingLot {
    private int parkinglotId;
    private int parkinglotCapasity;
    private int parkinglotAvailablePositionCount;
    private int parkingboyId;

    public int getParkinglotId() {
        return parkinglotId;
    }

    public void setParkinglotId(int parkinglotId) {
        this.parkinglotId = parkinglotId;
    }

    public int getParkinglotCapasity() {
        return parkinglotCapasity;
    }

    public void setParkinglotCapasity(int parkinglotCapasity) {
        this.parkinglotCapasity = parkinglotCapasity;
    }

    public int getParkinglotAvailablePositionCount() {
        return parkinglotAvailablePositionCount;
    }

    public void setParkinglotAvailablePositionCount(int parkinglotAvailablePositionCount) {
        this.parkinglotAvailablePositionCount = parkinglotAvailablePositionCount;
    }

    public int getParkingboyId() {
        return parkingboyId;
    }

    public void setParkingboyId(int parkingboyId) {
        this.parkingboyId = parkingboyId;
    }
}
