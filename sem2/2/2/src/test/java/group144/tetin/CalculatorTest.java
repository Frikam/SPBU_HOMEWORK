package group144.tetin;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void calculate() throws WrongExpressionException {
        Calculator calculator = new Calculator();
        assertEquals(-12, calculator.calculate("7 3 - 2 * 4 / 14 -"));
    }

    @Test
    public void calculateNegativeExpression() throws WrongExpressionException {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.calculate("-3 2 - -2 * 5 / -2 -"));
    }

}