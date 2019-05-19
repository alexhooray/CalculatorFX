import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.core.CalculatorService;
import sample.core.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTest {
    private CalculatorService calculatorService;
    @BeforeEach
    void setupCalculatorService() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("Input returns correct value after single number")
    void correctValueAfterSingleOperation() {
        calculatorService.input(Operation.THREE);
        assertEquals("3", calculatorService.show());
    }

    @Test
    @DisplayName("Input returns correct value after multiple numbers")
    void correctValueAfterMultipleNumbers() {
        calculatorService.input(Operation.EIGHT);
        assertEquals("8", calculatorService.show());
        calculatorService.input(Operation.THREE);
        assertEquals("83", calculatorService.show());
        calculatorService.input(Operation.ZERO);
        assertEquals("830", calculatorService.show());
        calculatorService.input(Operation.FIVE);
        assertEquals("8305", calculatorService.show());
    }

    @Test
    @DisplayName("Input returns correct value after multiple zero numbers")
    void correctValueAfterMultipleZeroNumbers() {
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ONE);
        calculatorService.input(Operation.ZERO);
        assertEquals("10", calculatorService.show());
    }

    @Test
    @DisplayName("Input shows one operator")
    void showOneOperator() {
        calculatorService.input(Operation.THREE);
        calculatorService.input(Operation.NINE);
        calculatorService.input(Operation.MINUS);
        calculatorService.input(Operation.PLUS);
        calculatorService.input(Operation.DIVIDE);
        calculatorService.input(Operation.MULTIPLY);
        assertEquals("39 * ", calculatorService.show());
    }

    @Test
    @DisplayName("Ignore multiple zeros in second value")
    void ignoreMultipleZerosInSecondValue() {
        calculatorService.input(Operation.ONE);
        calculatorService.input(Operation.TWO);
        calculatorService.input(Operation.PLUS);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ONE);
        assertEquals("12 + 1", calculatorService.show());
    }

    @Test
    @DisplayName("Input should ignore zeros only")
    void shouldIgnoreZerosOnly() {
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ZERO);
        assertEquals("0", calculatorService.show());
    }

    @Test
    @DisplayName("Input shows correct value after multiple zeros and after operator")
    void correctValueAfterMultipleZerosAndAfterOperator() {
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.PLUS);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ONE);
        assertEquals("0 + 1", calculatorService.show());
    }

    @Test
    @DisplayName("Correct value after few operations")
    void correctValueAfterFewOperations() {
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.ONE);
        calculatorService.input(Operation.SIX);
        calculatorService.input(Operation.PLUS);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.MINUS);
        assertEquals("16 + 0 - ", calculatorService.show());
    }

    @Test
    @DisplayName("No input zero output")
    void noInputZeroOutput() {
        assertEquals("0", calculatorService.show());
    }

    @Test
    @DisplayName("If first operation input should be added to zero")
    void firstOperationShouldBeAddedToZero() {
        calculatorService.input(Operation.PLUS);
        assertEquals("0 + ", calculatorService.show());
    }

    @Test
    @DisplayName("Correct result after plus operation")
    void correctResultAfterPlusOperation() {
        calculatorService.input(Operation.SEVEN);
        calculatorService.input(Operation.FOUR);
        calculatorService.input(Operation.PLUS);
        calculatorService.input(Operation.ONE);
        assertEquals(75, calculatorService.calculate());
    }

    @Test
    @DisplayName("Correct result without leftside")
    void correctResultWithoutLeftSide() {
        calculatorService.input(Operation.MINUS);
        calculatorService.input(Operation.TWO);
        assertEquals(-2, calculatorService.calculate());
    }

    @Test
    @DisplayName("Correct result after multiply operation")
    void correctResultAfterMultiplyOperation() {
        calculatorService.input(Operation.EIGHT);
        calculatorService.input(Operation.ONE);
        calculatorService.input(Operation.ONE);
        calculatorService.input(Operation.MULTIPLY);
        calculatorService.input(Operation.FIVE);
        assertEquals(4055, calculatorService.calculate());
    }

    @Test
    @DisplayName("Correct result after divide operation")
    void correctResultAfterDivideOperation() {
        calculatorService.input(Operation.EIGHT);
        calculatorService.input(Operation.DIVIDE);
        calculatorService.input(Operation.FOUR);
        assertEquals(2, calculatorService.calculate());
    }

    @Test
    @DisplayName("Result isn't integer after divide operation")
    void notIntegerResultAfterDivide() {
        calculatorService.input(Operation.TWO);
        calculatorService.input(Operation.ONE);
        calculatorService.input(Operation.DIVIDE);
        calculatorService.input(Operation.TWO);
        assertEquals(10.5, calculatorService.calculate());
    }

    @Test
    @DisplayName("Correct result after multiplying by zero")
    void correctResultAfterMultiplyingByZero() {
        calculatorService.input(Operation.NINE);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.MULTIPLY);
        calculatorService.input(Operation.ZERO);
        assertEquals(0, calculatorService.calculate());
    }

    @Test
    @DisplayName("Correct result after few numbers")
    void correctResultAfterFewNumbers(){
        calculatorService.input(Operation.THREE);
        calculatorService.input(Operation.EIGHT);
        calculatorService.input(Operation.PLUS);
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.NINE);
        calculatorService.input(Operation.MINUS);
        calculatorService.input(Operation.SEVEN);
        assertEquals(40, calculatorService.calculate());
    }


    @Test
    @DisplayName("Exception after division by zero")
    void exceptionAfterDivisionByZero() {
       Exception exception = assertThrows(ArithmeticException.class, () -> {
           calculatorService.input(Operation.ONE);
           calculatorService.input(Operation.DIVIDE);
           calculatorService.input(Operation.ZERO);
           calculatorService.calculate();
       });
       assertEquals("Error", exception.getMessage());
    }

    @Test
    @DisplayName("Calculate method works with empty fields")
    void calculateMethodWorksWithEmptyFields() {
        assertEquals(0, calculatorService.calculate());
    }

    @Test
    @DisplayName("Delete method works correct after input method")
    void deleteMethodWorksCorrectAfterInputMethod() {
        calculatorService.input(Operation.ONE);
        calculatorService.input(Operation.TWO);
        calculatorService.input(Operation.THREE);
        calculatorService.input(Operation.DIVIDE);
        calculatorService.delete();
        assertEquals("0", calculatorService.show());
    }

    @Test
    @DisplayName("Delete method works correct after calculate method")
    void deleteMethodWorksCorrectAfterCalculateMethod() {
        calculatorService.input(Operation.ZERO);
        calculatorService.input(Operation.FOUR);
        calculatorService.input(Operation.FIVE);
        calculatorService.input(Operation.SIX);
        calculatorService.input(Operation.PLUS);
        calculatorService.input(Operation.SEVEN);
        calculatorService.input(Operation.EIGHT);
        calculatorService.input(Operation.NINE);
        assertEquals(1245, calculatorService.calculate());
        calculatorService.delete();
        assertEquals("0", calculatorService.show());
    }
}