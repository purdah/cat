package cat.robottruck;

/**
 * The RobotTruck is an encapsulation of a Truck that can move around a bounded area.
 */
public class RobotTruck {

    private int x;
    private int y;
    private String direction;

    public RobotTruck(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction.toUpperCase();
    }

    public String move() {
        switch (direction) {
            case "NORTH" -> y++;
            case "SOUTH" -> y--;
            case "EAST" -> x++;
            case "WEST" -> x--;
        }
        return "Moved to (" + x + ", " + y + ")";
    }

    public String turnLeft() {
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
        return x + "," + y + "," + direction;
    }

}
