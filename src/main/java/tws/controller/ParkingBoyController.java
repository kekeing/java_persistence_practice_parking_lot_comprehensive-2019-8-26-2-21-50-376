package tws.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.ACCEPTED)
   public List<ParkingBoy> getAllParkingBoys(@RequestParam(name = "pageSize" , required = false) Integer pageSize,
                                             @RequestParam(name = "showPage" , required = false) Integer showPage){
       if (pageSize != null && showPage != null){return parkingBoyService.getAllParkingBoys(pageSize,showPage);}
       else  return parkingBoyService.getAllParkingBoys();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertParkingBoys(@RequestBody ParkingBoy parkingBoy){
        parkingBoyService.insertParkingBoys(parkingBoy);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateParkingBoyById(@RequestBody ParkingBoy parkingBoy){
        parkingBoyService.updateParkingBoyById(parkingBoy);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParkingBoyById(@PathVariable("id") int id){
        parkingBoyService.deleteParkingBoyById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ParkingBoy getparkingBoyById(@PathVariable("id") int id){
        return parkingBoyService.getparkingBoyById(id);
    }




}
