package cat.RobotTruck;

import cat.robottruck.RobotTruckController;
import cat.robottruck.RobotTruckService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RobotTruckController.class)
class RobotTruckControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RobotTruckService robotService;

    @Test
    void testPlace() throws Exception {
        String mockResponse = "Placed";
        when(robotService.place(0, 0, "NORTH")).thenReturn(mockResponse);

        mockMvc.perform(post("/robot/place")
                                .param("x", "0")
                                .param("y", "0")
                                .param("direction", "NORTH"))
               .andExpect(status().isOk())
               .andExpect(content().string(mockResponse));

        Mockito.verify(robotService).place(0, 0, "NORTH");
    }

    @Test
    void testMove() throws Exception {
        String mockResponse = "Moved";
        when(robotService.move()).thenReturn(mockResponse);

        mockMvc.perform(post("/robot/move"))
               .andExpect(status().isOk())
               .andExpect(content().string(mockResponse));

        Mockito.verify(robotService).move();
    }

    @Test
    void testLeft() throws Exception {
        String mockResponse = "Turned LEFT";
        when(robotService.turnLeft()).thenReturn(mockResponse);

        mockMvc.perform(post("/robot/left"))
               .andExpect(status().isOk())
               .andExpect(content().string(mockResponse));

        Mockito.verify(robotService).turnLeft();
    }

    @Test
    void testRight() throws Exception {
        String mockResponse = "Turned RIGHT";
        when(robotService.turnRight()).thenReturn(mockResponse);

        mockMvc.perform(post("/robot/right"))
               .andExpect(status().isOk())
               .andExpect(content().string(mockResponse));

        Mockito.verify(robotService).turnRight();
    }

    @Test
    void testReport() throws Exception {
        String mockResponse = "2,3,SOUTH";
        when(robotService.report()).thenReturn(mockResponse);

        mockMvc.perform(get("/robot/report"))
               .andExpect(status().isOk())
               .andExpect(content().string(mockResponse));

        Mockito.verify(robotService).report();
    }
}