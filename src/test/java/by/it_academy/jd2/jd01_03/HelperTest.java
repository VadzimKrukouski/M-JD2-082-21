package by.it_academy.jd2.jd01_03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HelperTest {

    @ParameterizedTest
    @MethodSource("minProvider")
    @DisplayName("find min value in array")
    public void findMin(double[] array, double result) {
        Assertions.assertEquals(result, Helper.findMin(array));
    }

    public static Stream<Arguments> minProvider() {
        return Stream.of(
                Arguments.arguments(new double[]{1.0, 2.0, 3.0}, 1.0),
                Arguments.arguments(new double[]{4.0, 8.0, 2.0}, 2.0)
        );
    }

    @ParameterizedTest
    @MethodSource("maxProvider")
    @DisplayName("find max value in array")
    public void findMax(double[] array, double result) {
        Assertions.assertEquals(result, Helper.findMax(array));
    }

    public static Stream<Arguments> maxProvider() {
        return Stream.of(
                Arguments.arguments(new double[]{1.0, 2.0, 3.0}, 3.0),
                Arguments.arguments(new double[]{4.0, 8.0, 2.0}, 8.0)
        );
    }

    @ParameterizedTest
    @MethodSource("mulProvider")
    @DisplayName("mul matrix and vector")
    public void mul(double[][] matrix, double[] vector, double[] resultArray) {
        Assertions.assertArrayEquals(resultArray, Helper.mul(matrix, vector),1e-10);
    }

    public static Stream<Arguments> mulProvider() {
        return Stream.of(
                Arguments.arguments(new double[][]{{8.7, 7.6}, {5.3, 4.6}, {6.7, 1.6}}, new double[]{4.6, 3.8}, new double[]{68.90, 41.86, 36.90})

        );
    }


}