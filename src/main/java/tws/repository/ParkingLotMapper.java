package tws.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;

import java.util.List;

@Mapper
public interface ParkingLotMapper {
    @Insert("insert into parkinglot values (#{parkingLot.parkinglotId},#{parkingLot.parkinglotCapasity},#{parkingLot.parkinglotAvailablePositionCount},#{parkingLot.parkingboyId})")
    void insertParkingLot(@Param("parkingLot") ParkingLot parkingLot);
    @Select("select * from parkinglot")
    List<ParkingLot> getAllParkingLot();
    @Select("select * from parkinglot where parkingboyId = #{parkingboyId}")
    List<ParkingLot> getAllParkingLotById(@Param("parkingboyId") int parkingboyId);

}
