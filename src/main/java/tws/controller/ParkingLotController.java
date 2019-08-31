package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ParkingLot> getAllParkingLots(){
        return parkingLotService.getAllParkingLots();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertParkingLot(@RequestBody ParkingLot parkingLot){
        parkingLotService.insertParkingLot(parkingLot);
    }
    @GetMapping(value = "/{parkingboyId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ParkingLot> getAllParkingLotsById(@PathVariable("parkingboyId") int parkingboyId){
       return parkingLotService.getAllParkingLotsById(parkingboyId);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateParkingLot(@RequestBody ParkingLot parkingLot){
        parkingLotService.updateParkingLot(parkingLot);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParkingLotById(@PathVariable("id") int id){
        parkingLotService.deleteParkingLotById(id);
    }

}
