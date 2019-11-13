package com.kata.marsrover;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class PointSpec {

    Point point;
    private final int location = 5;
    private final int maxLocation = 9;

    @Before
    public void beforePointTest() {
        point = new Point(location, maxLocation);
    }

    @Test
    public void newInstanceShouldSetLocationAndMaxLocationParams() {
        assertThat(point.getLocation()).isEqualTo(location);
        assertThat(point.getMaxLocation()).isEqualTo(maxLocation);
    }

    @Test
    public void forwardShouldIncreasePointValueByOne() {
        int expected = point.getLocation() + 1;
        point.forward();
        assertThat(point.getLocation()).isEqualTo(expected);
    }

    @Test
    public void backwardShouldDecreasePointValueByOne() {
        int expected = point.getLocation() - 1;
        point.backward();
        assertThat(point.getLocation()).isEqualTo(expected);
    }

    @Test
    public void forwardShouldSetValueToZeroIfMaxLocationIsPassed() {
        point.setLocation(point.getMaxLocation());
        point.forward();
        assertThat(point.getLocation()).isZero();
    }

    @Test
    public void backwardShouldSetValueToMaxLocationIfZeroLocationIsPassed() {
        point.setLocation(0);
        point.backward();
        assertThat(point.getLocation()).isEqualTo(point.getMaxLocation());
    }

}