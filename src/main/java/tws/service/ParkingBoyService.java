package tws.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;

import java.util.List;

@Service
public class ParkingBoyService {

    @Autowired
    private ParkingBoyMapper parkingBoyMapper;


    public List<ParkingBoy> getAllParkingBoys(){
        List<ParkingBoy> parkingBoys = parkingBoyMapper.getAllParkingBoy();
        for (ParkingBoy parkingBoy : parkingBoys){
            String result = parkingBoy.getParkingboyName();
            result+= "zybank";
            parkingBoy.setParkingboyName(result);
        }
        return parkingBoys;
    }
    public void insertParkingBoys(@RequestBody ParkingBoy parkingBoy){
        parkingBoyMapper.insertParkingBoy(parkingBoy);
    }
}
