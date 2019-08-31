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
    @Select("select * from parkingboy OFFSET #{skippedNumber} ROWS FETCH NEXT #{pageSize} ROWS ONLY")
    List<ParkingBoy> getAllParkingBoyInPage(@Param("skippedNumber") int skippedNumber,@Param("pageSize") int pageSize);
    @Update("update parkingboy set parkingboyName = #{parkingBoy.parkingboyName}, parkingboyAge = #{parkingBoy.parkingboyAge}  where parkingboyId = #{parkingBoy.parkingboyId} ")
    void updateParkingBoyById(@Param("parkingBoy") ParkingBoy parkingBoy);
    @Delete("delete from parkingboy where parkingboyId = #{id}")
    void deleteParkingBoyById(@Param("id") int id);
    @Select("select * from parkingboy where parkingboyId = #{id}")
    ParkingBoy getparkingBoyById(@Param("id") int id);
}
