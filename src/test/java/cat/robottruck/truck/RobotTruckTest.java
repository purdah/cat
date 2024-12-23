package cat.robottruck.truck;

import cat.robottruck.RobotTruck;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RobotTruckTest {

    private RobotTruck robotTruck;

    @Test
    void testInitialPositionAndDirection() {
        robotTruck = new RobotTruck();
        robotTruck.place(2, 2, "NORTH");
        assertThat(robotTruck.report())
                .isEqualTo("2,2,NORTH")
                .as("Initial position and direction should be correctly set");
    }

    @Test
    void testMoveNorth() {
        robotTruck = new RobotTruck();
        robotTruck.place(2, 2, "NORTH");
        robotTruck.move();
        assertThat(robotTruck.report())
                .isEqualTo("2,3,NORTH")
                .as("Robot should move one step NORTH");
    }

    @Test
    void testMoveSouth() {
        robotTruck = new RobotTruck();
        robotTruck.place(2, 2, "SOUTH");
        robotTruck.move();
        assertThat(robotTruck.report())
                .isEqualTo("2,1,SOUTH")
                .as("Robot should move one step SOUTH");
    }

    @Test
    void testMoveEast() {
        robotTruck = new RobotTruck();
        robotTruck.place(2, 2, "EAST");
        robotTruck.move();
        assertThat(robotTruck.report())
                .isEqualTo("3,2,EAST")
                .as("Robot should move one step EAST");
    }

    @Test
    void testMoveWest() {
        robotTruck = new RobotTruck();
        robotTruck.place(2, 2, "WEST");
        robotTruck.move();
        assertThat(robotTruck.report())
                .isEqualTo("1,2,WEST")
                .as("Robot should move one step WEST");
    }

    @Test
    void testTurnLeft() {
        robotTruck = new RobotTruck();
        robotTruck.place(2, 2, "NORTH");
        String result = robotTruck.turnLeft();
        assertThat(robotTruck.report())
                .isEqualTo("2,2,WEST")
                .as("Robot should face WEST after turning LEFT from NORTH");

        result = robotTruck.turnLeft();
        assertThat(robotTruck.report())
                .isEqualTo("2,2,SOUTH")
                .as("Robot should face SOUTH after turning LEFT from WEST");
    }

    @Test
    void testTurnRight() {
        robotTruck = new RobotTruck();
        robotTruck.place(2, 2, "NORTH");
        robotTruck.turnRight();
        assertThat(robotTruck.report())
                .isEqualTo("2,2,EAST")
                .as("Robot should face EAST after turning RIGHT from NORTH");

        robotTruck.turnRight();
        assertThat(robotTruck.report())
                .isEqualTo("2,2,SOUTH")
                .as("Robot should face SOUTH after turning RIGHT from EAST");
    }

    @Test
    void testReport() {
        robotTruck = new RobotTruck();
        robotTruck.place(2, 3, "EAST");
        assertThat(robotTruck.report())
                .isEqualTo("2,3,EAST")
                .as("Report should return the correct position and direction");

        robotTruck = new RobotTruck();
        robotTruck.place(0, 0, "SOUTH");
        assertThat(robotTruck.report())
                .isEqualTo("0,0,SOUTH")
                .as("Report should return the correct position and direction");
    }

    @Test
    void testInitialPlacementOutOfBounds() {
        robotTruck = new RobotTruck();
        robotTruck.place(-4, -4, "NORTH");
        robotTruck.move();
        assertThat(robotTruck.report())
                .isEqualTo("ROBOT MISSING")
                .as("RobotTruck can not be created outside of the available area");
    }

    @Test
    void testMoveOutOfBoundsToTheNorth() {
        robotTruck = new RobotTruck();
        robotTruck.place(4, 4, "NORTH");
        robotTruck.move();
        assertThat(robotTruck.report())
                .isEqualTo("4,4,NORTH")
                .as("RobotTruck can not be moved outside of the available area and should retain the original position and direction");
    }

}
