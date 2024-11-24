package cat.robottruck.area;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SquareAreaTest {

    @Test
    void testValidCoordinates() {
        int gridWidthAndHeight = 5;
        SquareArea squareArea = new SquareArea(gridWidthAndHeight);

        assertThat(squareArea.areValidCoordinates(0, 0)).isTrue();
        assertThat(squareArea.areValidCoordinates(4, 4)).isTrue();
        assertThat(squareArea.areValidCoordinates(0, 4)).isTrue();
        assertThat(squareArea.areValidCoordinates(4, 0)).isTrue();
    }

    @Test
    void testInvalidCoordinates() {
        int gridWidthAndHeight = 3;
        SquareArea squareArea = new SquareArea(gridWidthAndHeight);

        assertThat(squareArea.areValidCoordinates(0, 0)).isTrue();
        assertThat(squareArea.areValidCoordinates(4, 4)).isFalse();
        assertThat(squareArea.areValidCoordinates(0, 4)).isFalse();
        assertThat(squareArea.areValidCoordinates(4, 0)).isFalse();
        assertThat(squareArea.areValidCoordinates(-1, 0)).isFalse();
        assertThat(squareArea.areValidCoordinates(0, -1)).isFalse();
    }
}