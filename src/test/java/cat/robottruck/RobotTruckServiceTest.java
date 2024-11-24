package cat.robottruck;

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
                .isEqualTo("0,0,EAST");
    }

    @Test
    void report() {
        robotService.place(0, 0, "NORTH");
        assertThat(robotService.report())
                .isEqualTo("0,0,NORTH");
    }

    @Test
    void tesMoveOutOfAreaDoesNotMoveTheTruck() {
        robotService.place(4, 4, "NORTH");
        robotService.move();
        assertThat(robotService.report())
                .isEqualTo("4,4,NORTH");

        robotService.place(0, 0, "SOUTH");
        robotService.move();
        assertThat(robotService.report())
                .isEqualTo("0,0,SOUTH");

        robotService.place(4, 4, "EAST");
        robotService.move();
        assertThat(robotService.report())
                .isEqualTo("4,4,EAST");

        robotService.place(0, 0, "WEST");
        robotService.move();
        assertThat(robotService.report())
                .isEqualTo("0,0,WEST");

    }

    @Test
    void testPlaceOutOfBoundsReportsMissingRobot() {
        robotService.place(-10, 0, "WEST");

        assertThat(robotService.report())
                .isEqualTo("ROBOT MISSING");

        // Should ignore any move or turn commands if no robot
        robotService.move();
        robotService.turnLeft();
        robotService.turnRight();


        assertThat(robotService.report())
                .isEqualTo("ROBOT MISSING");

    }
}