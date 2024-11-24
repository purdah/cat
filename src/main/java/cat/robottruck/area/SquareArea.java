package cat.robottruck.area;

/**
 * This is a representation of a square shaped area that has the same width and height.
 * The grid is zero based with the bottom left cell being addressed as 0,0 and the top right cell would be N,N where N is the field gridWidthAndHeight - 1
 */
public class SquareArea implements MovementArea {
    private final int gridWidthAndHeight;

    public SquareArea(int gridWidthAndHeight) {
        if (gridWidthAndHeight < 1) {
            throw new IllegalArgumentException("Grid must be at least one by one, value: " + gridWidthAndHeight + " is invalid");
        }
        this.gridWidthAndHeight = gridWidthAndHeight;
    }

    @Override
    public boolean areValidCoordinates(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        return x < gridWidthAndHeight && y < gridWidthAndHeight;
    }
}
