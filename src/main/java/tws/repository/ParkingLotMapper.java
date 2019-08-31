package tws.repository;

import org.apache.ibatis.annotations.*;
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
    @Update("update parkinglot set parkinglotCapasity = #{parkingLot.parkinglotCapasity}, parkinglotAvailablePositionCount = #{parkingLot.parkinglotAvailablePositionCount},parkingboyId = #{parkingLot.parkingboyId}  where parkinglotId = #{parkingLot.parkinglotId}")
    void updateParkingLot(@Param("parkingLot") ParkingLot parkingLot);
    @Delete("delete from parkinglot where parkinglotId = #{id}")
    void deleteParkingLotById(@Param("id") int id);
}
