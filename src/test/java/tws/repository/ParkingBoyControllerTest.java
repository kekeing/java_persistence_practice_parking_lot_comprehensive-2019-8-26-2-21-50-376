package tws.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import tws.service.ParkingBoyService;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingBoyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ParkingBoyService parkingBoyService;
    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper ObjectMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
    }

    @Test
    public void should_get_all_parking_boy_when_call_get_all_parking_boy() throws Exception{
        //given
        List<ParkingBoy> parkingBoyList = new ArrayList<>();
        parkingBoyList.add(new ParkingBoy(1,"123",21));
        String getString = ObjectMapper.writeValueAsString(parkingBoyList);
        when(parkingBoyService.getAllParkingBoys()).thenReturn(parkingBoyList);

        //when
        ResultActions resultActions = this.mockMvc.perform(get("/parkingBoys"));

        //then
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(getString)).andDo(print());

    }
    @Test
    public void should_insert_into_parking_boy_when_call_insert_parking_boy_given_a_parking_boy() throws Exception{
        //given
        ParkingBoy parkingBoy = new ParkingBoy(1,"cao",18);
        String getString = ObjectMapper.writeValueAsString(parkingBoy);

        //when
        ResultActions resultActions =  this.mockMvc.perform(post("/parkingBoys")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(getString));

        //then
        resultActions.andExpect(status().isCreated());
    }
    @Test
    public void should_update_parking_boy_when_call_update_parking_boy_given_a_parking_boy() throws Exception{
        //given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'yang', '21');");
        ParkingBoy updateParkingBoy = new ParkingBoy(1,"cao",18);
        String getString = ObjectMapper.writeValueAsString(updateParkingBoy);

        //when
        ResultActions resultActions =  this.mockMvc.perform(MockMvcRequestBuilders
                .put("/parkingBoys")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getString));

        //then
        resultActions.andExpect(status().isNoContent());
    }
    @Test
    public void should_delete_parking_boy_when_call_update_parking_boy_given_a_parking_boy() throws Exception{
        //given
        jdbcTemplate.execute("INSERT INTO parkingboy VALUES(1,'yang', '21');");
        int id = 1;

        //when
        ResultActions resultActions =  this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/parkingBoys/{id}",id));

        //then
        resultActions.andExpect(status().isNoContent());
    }


}
