package by.it_academy.jd2.jd01_03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class HelperTest {

    @ParameterizedTest
    @MethodSource("minProvider")
    @DisplayName("find min value in array")
    void findMin(double[] array, double result) {
        Assertions.assertEquals(result, Helper.findMin(array));
    }

    public static Stream<Arguments> minProvider() {
        return Stream.of(
                Arguments.arguments(new double[]{1.0, 2.0, 3.0}, 1.0),
                Arguments.arguments(new double[]{4.0, 8.0, 2.0}, 2.0)
        );
    }

    @Test
    void findMax() {
    }

    @Test
    void sort() {
    }

    @Test
    void mul() {
    }

    @Test
    void testMul() {
    }
}