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
   public List<ParkingBoy> getAllParkingBoys(@RequestParam(name = "pageSize" , required = false) Integer pageSize,
                                             @RequestParam(name = "showPage" , required = false) Integer showPage){
       if (pageSize != null && showPage != null){return parkingBoyService.getAllParkingBoys(pageSize,showPage);}
       else  return parkingBoyService.getAllParkingBoys();
    }
    @GetMapping("/")
    public List<ParkingBoy> getAllParkingBoysInpage(@RequestParam(name = "showPage" , required = false) int showPage,
                                                    @RequestParam(name = "pageSize" , required = false) int pageSize){
        return parkingBoyService.getAllParkingBoyInPage(showPage,pageSize);
    }
    @PostMapping
    public void insertParkingBoys(@RequestBody ParkingBoy parkingBoy){
        parkingBoyService.insertParkingBoys(parkingBoy);
    }




}
