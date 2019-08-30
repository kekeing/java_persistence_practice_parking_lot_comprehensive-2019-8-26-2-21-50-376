package tws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.util.List;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotMapper parkingLotMapper;

    public List<ParkingLot> getAllParkingLots() {
        return parkingLotMapper.getAllParkingLot();
    }

    public void insertParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotMapper.insertParkingLot(parkingLot);
    }
    public List<ParkingLot> getAllParkingLotsById(@PathVariable("parkingboyId") int parkingboyId){
        return parkingLotMapper.getAllParkingLotById(parkingboyId);
    }
}
