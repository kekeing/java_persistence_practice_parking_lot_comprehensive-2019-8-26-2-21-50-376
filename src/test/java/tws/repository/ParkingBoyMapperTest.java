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
public class ParkingBoyMapperTest {

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
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'parkingBoys_1',18);");
        // when
        List<ParkingBoy> employeeList = parkingBoyMapper.getAllParkingBoy();
        // then
        assertEquals(1, employeeList.get(0).getParkingboyId());
        assertEquals("parkingBoys_1", employeeList.get(0).getParkingboyName());
    }

    @Test
    public void should_get_parking_boy_in_pages_when_call_get_parking_boy_given_insert_into_parking_boy_skippedNumber_1_pageSize_2(){
        //given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan',18);");
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(2,'lisi',19);");
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(3,'wangwu',20);");
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(4,'a',21);");
        int skippedNumber = 1;
        int pageSize = 2;

        //when
        List<ParkingBoy> employeeList = parkingBoyMapper.getAllParkingBoyInPage(skippedNumber,pageSize);

        //then
        assertEquals(2,employeeList.size());
        assertEquals(2,employeeList.get(0).getParkingboyId());
        assertEquals(3,employeeList.get(1).getParkingboyId());
        assertEquals("lisi",employeeList.get(0).getParkingboyName());
        assertEquals("wangwu",employeeList.get(1).getParkingboyName());
        assertEquals(19,employeeList.get(0).getParkingboyAge());
        assertEquals(20,employeeList.get(1).getParkingboyAge());

    }
    @Test
    public void should_get_parking_boy_in_pages_when_call_get_parking_boy_given_insert_into_parking_boy_skippedNumber_2_pageSize_2(){
        //given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'zhangsan',18);");
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(2,'lisi',19);");
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(3,'wangwu',20);");
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(4,'a',21);");
        int skippedNumber = 2;
        int pageSize = 2;

        //when
        List<ParkingBoy> employeeList = parkingBoyMapper.getAllParkingBoyInPage(skippedNumber,pageSize);

        //then
        assertEquals(2,employeeList.size());
        assertEquals(3,employeeList.get(0).getParkingboyId());
        assertEquals(4,employeeList.get(1).getParkingboyId());
        assertEquals("wangwu",employeeList.get(0).getParkingboyName());
        assertEquals("a",employeeList.get(1).getParkingboyName());
        assertEquals(20,employeeList.get(0).getParkingboyAge());
        assertEquals(21,employeeList.get(1).getParkingboyAge());

    }
}
