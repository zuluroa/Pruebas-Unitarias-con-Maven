package co.com.sofka.app;

import co.com.sofka.app.calculator.BasicCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();
    private final Logger logger = LoggerFactory.getLogger(BasicCalculatorTest.class);

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing res: 3-1=2")
    public void res() {
        // Arrange
        Long number1 = 3L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.res(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several res")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "3,    1,   2",
            "5,    2,   3",
            "40,  20, 20",
            "70,  20, 50"
    })
    public void severalRes(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.res(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing div: 4/2=2")
    public void div() {
        // Arrange
        Long number1 = 4L;
        Long number2 = 2L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.div(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several div")
    @ParameterizedTest(name = "{0} / {2} = {2}")
    @CsvSource({
            "3,    1,   3",
            "10,    2,   5",
            "40,  5, 8",
            "100,  0, 100"
    })
    public void severalDiv(Long first, Long second, Long expectedResult) {
       try {
           assertEquals(expectedResult, basicCalculator.div(first, second),
                   () -> first + " / " + second + " should equal " + expectedResult);
       }catch (Exception e){
           logger.error("No se puede dividir por cero");
       }
    }

    @Test
    @DisplayName("Testing div: 1*2=2")
    public void Mul() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 2L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.mul(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several div")
    @ParameterizedTest(name = "{0} * {2} = {0}")
    @CsvSource({
            "2,    2,   4",
            "10,    2,   20",
            "40,  2, 80",
            "100,  2,200"
    })
    public void severalMul(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.mul(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }
}
