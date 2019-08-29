package tws.repository;

import org.apache.ibatis.annotations.*;
import tws.entity.ParkingBoy;

import java.util.List;
@Mapper
public interface ParkingBoyMapper {
    @Insert("insert into parkingboy values (#{parkingBoy.parkingboyId},#{parkingBoy.parkingboyName},#{parkingBoy.parkingboyAge})")
    void insertParkingBoy(@Param("parkingBoy") ParkingBoy parkingBoy);
    @Select("select * from parkingboy")
    List<ParkingBoy> getAllParkingBoy();
//    @Update("update parkingboy set name = #{parkingBoy.name}, age = #{parkingBoy.age}  where id = #{parkingBoy.id} ")
//    void updateParkingBoyById(@Param("parkingBoy") ParkingBoy parkingBoy);
//    @Delete("delete from parkingboy where id = #{id}")
//    void deleteParkingBoyById(@Param("id") int id);
//    @Select("select * from parkingboy where id = #{id}")
//    ParkingBoy getparkingBoyById(@Param("id") int id);
}
