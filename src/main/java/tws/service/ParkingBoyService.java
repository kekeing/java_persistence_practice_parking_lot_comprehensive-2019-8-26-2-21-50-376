package tws.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;

import java.util.List;

@Service
public class ParkingBoyService {

    @Autowired
    private ParkingBoyMapper parkingBoyMapper;


    public List<ParkingBoy> getAllParkingBoyInPage(int showPage,int pageSize){
        int skippedNumber = (showPage - 1) * pageSize ;
        return parkingBoyMapper.getAllParkingBoyInPage(skippedNumber,pageSize);
    }
    public List<ParkingBoy> getAllParkingBoys(){
        List<ParkingBoy> parkingBoys = parkingBoyMapper.getAllParkingBoy();
        for (ParkingBoy parkingBoy : parkingBoys){
            String result = parkingBoy.getParkingboyName();
            result+= "zybank";
            parkingBoy.setParkingboyName(result);
        }
        return parkingBoys;
    }
    public List<ParkingBoy> getAllParkingBoys(int pageSize , int showPage){
        List<ParkingBoy> parkingBoys = parkingBoyMapper.getAllParkingBoy();
        for (ParkingBoy parkingBoy : parkingBoys){
            String result = parkingBoy.getParkingboyName();
            result+= "zybank";
            parkingBoy.setParkingboyName(result);
        }
        int allNumbers = parkingBoys.size();
        int allPages = (allNumbers / pageSize);
        if (allNumbers % pageSize != 0){
            allPages ++;
        }
        if (showPage > allPages){return null;}
        int start = (showPage -1) * pageSize;
        int end = (start + pageSize) > allNumbers ? allNumbers : (start + pageSize);
        List<ParkingBoy> showParkingBoys = parkingBoys.subList(start,end);
        return showParkingBoys;
    }
    public void insertParkingBoys(ParkingBoy parkingBoy){
        parkingBoyMapper.insertParkingBoy(parkingBoy);

    }

    public void updateParkingBoyById(ParkingBoy parkingBoy){
        parkingBoyMapper.updateParkingBoyById(parkingBoy);
    }

    public void deleteParkingBoyById(int id){
        parkingBoyMapper.deleteParkingBoyById(id);
    }

    public ParkingBoy getparkingBoyById(int id){
        return parkingBoyMapper.getparkingBoyById(id);
    }
}

