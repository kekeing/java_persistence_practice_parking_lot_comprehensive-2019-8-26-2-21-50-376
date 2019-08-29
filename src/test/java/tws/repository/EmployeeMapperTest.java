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

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {

    @Autowired
    private ParkingBoyMapper parkingBoyMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void clearDB() {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
    }

    @Test
    public void shouldFetchAllParkingBoys() {
        // given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan',18);");
        // when
        List<ParkingBoy> employeeList = parkingBoyMapper.getAllParkingBoy();
        // then
        assertEquals(1, employeeList.size());
    }

    @Test
    public void shouldGetParkingBoyWhenCallInsertParkingBoy() {
        // given
        parkingBoyMapper.insertParkingBoy(new ParkingBoy(1, "parkingBoys_1",18));
        // when
        List<ParkingBoy> employeeList = parkingBoyMapper.getAllParkingBoy();
        // then
        assertEquals(1, employeeList.get(0).getParkingboyId());
        assertEquals("parkingBoys_1", employeeList.get(0).getParkingboyName());
    }
}
