package tws.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;

import java.util.List;

@RestController
@RequestMapping("/parkingBoys")
public class ParkingBoyController {
    @Autowired
    private ParkingBoyMapper parkingBoyMapper;

    @GetMapping
   public List<ParkingBoy> getAllParkingBoys(){
        return parkingBoyMapper.getAllParkingBoy();
    }
    @PostMapping
    public void insertParkingBoys(@RequestBody ParkingBoy parkingBoy){
        parkingBoyMapper.insertParkingBoy(parkingBoy);
    }




}
