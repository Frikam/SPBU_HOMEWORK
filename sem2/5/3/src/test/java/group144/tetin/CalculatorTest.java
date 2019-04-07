package group144.tetin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void CalcalateTest() {
        Calculator calculator = new Calculator();
        String answer = calculator.calculateExpression("5 + 3 / 3 - 17 * 2");
        assertEquals("-28", answer);
    }

    @Test
    public void divisionByZeroTest() {
        Calculator calculator = new Calculator();
        assertThrows(Exception.class, () -> calculator.calculateExpression("3 + 4 + 5 / 0"));
    }
}