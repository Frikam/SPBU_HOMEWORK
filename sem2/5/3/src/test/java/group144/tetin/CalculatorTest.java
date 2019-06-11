package group144.tetin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void CalcalateTest() throws WrongExpressionException {
        Calculator calculator = new Calculator();
        String answer = calculator.calculateExpression("5 + 3 / 3 - 17 * 2");
        assertEquals("-28", answer);
    }

    @Test
    public void divisionByZeroTest() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.calculateExpression("3 + 4 + 5 / 0"));
    }

    @Test
    public void wrongExpressionTest1() {
        Calculator calculator = new Calculator();
        assertThrows(WrongExpressionException.class, () -> calculator.calculateExpression("3 ++ 4 + "));
    }

    @Test
    public void wrongExpressionTest2() {
        Calculator calculator = new Calculator();
        assertThrows(WrongExpressionException.class, () -> calculator.calculateExpression("3 + 4 + "));
    }

    @Test
    public void simpleExpressionTest() throws WrongExpressionException {
        Calculator calculator = new Calculator();
        assertEquals("1", calculator.calculateExpression("1 "));
    }
}