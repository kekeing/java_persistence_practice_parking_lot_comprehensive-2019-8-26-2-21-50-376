package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.util.List;
@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping
    public List<ParkingLot> getAllParkingLots(){
        return parkingLotMapper.getAllParkingLot();
    }
    @PostMapping
    public void insertParkingLot(@RequestBody ParkingLot parkingLot){
        parkingLotMapper.insertParkingLot(parkingLot);
    }
    @GetMapping(value = "/{parkingboyId}")
    public List<ParkingLot> getAllParkingLotsById(@PathVariable("parkingboyId") int parkingboyId){
       return parkingLotMapper.getAllParkingLotById(parkingboyId);

    }

}
