package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;
import tws.service.ParkingLotService;

import java.util.List;
@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping
    public List<ParkingLot> getAllParkingLots(){
        return parkingLotService.getAllParkingLots();
    }
    @PostMapping
    public void insertParkingLot(@RequestBody ParkingLot parkingLot){
        parkingLotService.insertParkingLot(parkingLot);
    }
    @GetMapping(value = "/{parkingboyId}")
    public List<ParkingLot> getAllParkingLotsById(@PathVariable("parkingboyId") int parkingboyId){
       return parkingLotService.getAllParkingLotsById(parkingboyId);

    }

}
