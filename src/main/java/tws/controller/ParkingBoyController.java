package tws.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;
import tws.service.ParkingBoyService;

import java.util.List;

@RestController
@RequestMapping("/parkingBoys")
public class ParkingBoyController {
    @Autowired
    private ParkingBoyService parkingBoyService;

    @GetMapping
   public List<ParkingBoy> getAllParkingBoys(){
        return   parkingBoyService.getAllParkingBoys();
    }
    @PostMapping
    public void insertParkingBoys(@RequestBody ParkingBoy parkingBoy){
        parkingBoyService.insertParkingBoys(parkingBoy);
    }




}
