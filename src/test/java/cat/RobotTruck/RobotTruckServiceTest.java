package cat.RobotTruck;

import cat.robottruck.RobotTruckService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RobotTruckServiceTest {

    private RobotTruckService robotService;

    @BeforeEach
    void setUp() {
        robotService = new RobotTruckService();
    }

    @Test
    void placeIsWithinBounds() {
        assertThat(robotService.place(0, 0, "NORTH")).isEqualTo("0,0,NORTH");
        assertThat(robotService.place(0, 4, "NORTH")).isEqualTo("0,4,NORTH");
        assertThat(robotService.place(4, 0, "NORTH")).isEqualTo("4,0,NORTH");
        assertThat(robotService.place(4, 4, "NORTH")).isEqualTo("4,4,NORTH");
    }

    @Test
    void move() {
        robotService.place(0, 0, "NORTH");
        robotService.move();
        assertThat(robotService.report())
                .isEqualTo("0,1,NORTH");
    }

    @Test
    void turnLeft() {
        robotService.place(0, 0, "NORTH");
        robotService.turnLeft();
        assertThat(robotService.report())
                .isEqualTo("0,0,WEST");
    }

    @Test
    void turnRight() {
        robotService.place(0, 0, "NORTH");
        robotService.turnRight();
        assertThat(robotService.report())
                .isEqualTo("0,1,EAST");
    }

    @Test
    void report() {
        robotService.place(0, 0, "NORTH");
        assertThat(robotService.report())
                .isEqualTo("0,0,NORTH");
    }
}