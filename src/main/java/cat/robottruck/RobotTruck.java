package cat.robottruck;

import cat.robottruck.area.MovementArea;
import cat.robottruck.area.SquareArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The RobotTruck is an encapsulation of a Truck that can move around a bounded area.
 */
public class RobotTruck {
    private static final Logger logger = LoggerFactory.getLogger(RobotTruck.class);

    private boolean hasBeenPlaced = false;
    private int x;
    private int y;
    private String direction;
    private final MovementArea movementArea;

    public RobotTruck() {
        movementArea = new SquareArea(5);

    }

    public boolean place(int x, int y, String direction) {
        if (movementArea.areValidCoordinates(x, y)) {
            // valid to set new position
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.hasBeenPlaced = true;
            return true;
        } else {
            // invalid position so nothing to change
            if (hasBeenPlaced) {
                logger.error("Truck is being moved to an invalid position [{},{}], keeping existing position [{},{}]", x, y, this.x, this.y);
            } else {
                logger.error("Truck has not yet been placed");
            }
            return false;
        }
    }

    public String move() {
        if (!hasBeenPlaced) {
            return "Truck is not moveable";
        }
        int originalXValue = x;
        int originalYValue = y;
        switch (direction) {
            case "NORTH" -> y++;
            case "SOUTH" -> y--;
            case "EAST" -> x++;
            case "WEST" -> x--;
        }
        if (!movementArea.areValidCoordinates(x, y)) {
            logger.error("Robot Truck was attempted to be moved outside the area from {},{} to {},{}", originalXValue, originalYValue, x, y);
            y = originalYValue;
            x = originalXValue;
        }
        return "Moved to (" + x + ", " + y + ")";
    }

    public String turnLeft() {
        if (!hasBeenPlaced) {
            return "Truck is not turnable";
        }
        direction = switch (direction) {
            case "NORTH" -> "WEST";
            case "SOUTH" -> "EAST";
            case "EAST" -> "NORTH";
            case "WEST" -> "SOUTH";
            default -> direction;
        };
        return "Turned LEFT. Now facing " + direction;
    }

    public String turnRight() {
        if (!hasBeenPlaced) {
            return "Truck is not turnable";
        }
        direction = switch (direction) {
            case "NORTH" -> "EAST";
            case "SOUTH" -> "WEST";
            case "EAST" -> "SOUTH";
            case "WEST" -> "NORTH";
            default -> direction;
        };
        return "Turned RIGHT. Now facing " + direction;
    }

    public String report() {
        if (!hasBeenPlaced || !movementArea.areValidCoordinates(x, y)) {
            return "ROBOT MISSING";
        }
        return x + "," + y + "," + direction;
    }

    @Override
    public String toString() {
        if (hasBeenPlaced) {
            return "RobotTruck{" +
                    "x=" + x +
                    ", y=" + y +
                    ", direction='" + direction + '\'' +
                    ", movementArea=" + movementArea +
                    '}';
        } else {
            return "RobotTruck{invalid coordinates}";
        }
    }
}
