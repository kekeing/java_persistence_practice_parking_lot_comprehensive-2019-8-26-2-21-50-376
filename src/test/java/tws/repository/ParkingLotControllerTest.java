package tws.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;
import tws.service.ParkingBoyService;
import tws.service.ParkingLotService;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ParkingBoyService parkingBoyService;
    @MockBean
    private ParkingLotService parkingLotService;
    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper ObjectMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkinglot");
    }
    @Test
    public void should_get_all_parking_lot_when_call_get_all_parking_lot() throws Exception{
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(1,30,21,1));
        String getString = ObjectMapper.writeValueAsString(parkingLots);
        when(parkingLotService.getAllParkingLots()).thenReturn(parkingLots);

        //when
        ResultActions resultActions = this.mockMvc.perform(get("/parkingLots"));

        //then
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(getString)).andDo(print());

    }
    @Test
    public void should_insert_into_parking_lot_when_call_insert_parking_lot_given_a_parking_lot() throws Exception{
        //given
        ParkingLot parkingLot = new ParkingLot(1,20,18,1);
        String getString = ObjectMapper.writeValueAsString(parkingLot);

        //when
        ResultActions resultActions =  this.mockMvc.perform(post("/parkingLots")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getString));

        //then
        resultActions.andExpect(status().isCreated());
    }
    @Test
    public void should_update_parking_boy_when_call_update_parking_boy_given_a_parking_boy() throws Exception{
        //given
        jdbcTemplate.execute("INSERT INTO parkinglot VALUES(1,20,20,1);");
        ParkingLot updateParkingLot = new ParkingLot(1,30,18,1);
        String getString = ObjectMapper.writeValueAsString(updateParkingLot);

        //when
        ResultActions resultActions =  this.mockMvc.perform(MockMvcRequestBuilders
                .put("/parkingLots")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getString));

        //then
        resultActions.andExpect(status().isNoContent());
    }
    @Test
    public void should_delete_parking_boy_when_call_update_parking_boy_given_a_parking_boy() throws Exception{
        //given
        jdbcTemplate.execute("INSERT INTO parkinglot VALUES(1,20,20,1);");
        int id = 1;

        //when
        ResultActions resultActions =  this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/parkingLots/{id}",id));

        //then
        resultActions.andExpect(status().isNoContent());
    }

}
