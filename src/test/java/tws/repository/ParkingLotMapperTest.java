package tws.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingLotMapperTest {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void clearDB() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
    }

    @Test
    public void shouldFetchAllParkingLots() {
        // given
        jdbcTemplate.execute("INSERT INTO parkinglot VALUES(1, 10, 11, 1);");
        // when
        List<ParkingLot> parkingLotsList = parkingLotMapper.getAllParkingLot();
        // then
        assertEquals(1, parkingLotsList.size());
    }

    @Test
    public void shouldGetParkingLotWhenCallInsertParkingLot() {
        // given
        ParkingLot parkingLot = new ParkingLot(1, 10, 10, 1);
        parkingLotMapper.insertParkingLot(parkingLot);
        // when
        List<ParkingLot> parkingLotsList = parkingLotMapper.getAllParkingLot();
        // then
        assertEquals(1, parkingLotsList.get(0).getParkinglotId());
        assertEquals(10, parkingLotsList.get(0).getParkinglotCapasity());
        assertEquals(10, parkingLotsList.get(0).getParkinglotAvailablePositionCount());
        assertEquals(1,parkingLotsList.get(0).getParkingboyId());
    }
}

