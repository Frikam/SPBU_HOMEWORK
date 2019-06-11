package group144.tetin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    @Test
    public void calculatePlusTest() {
        Controller controller = new Controller();
        int firstNumber = 3;
        int secondNumber = 5;
        char operation = '+';
        assertEquals("8", controller.calculate(firstNumber, secondNumber, operation));
    }

    @Test
    public void calculateMinusTest() {
        Controller controller = new Controller();
        int firstNumber = 3;
        int secondNumber = 5;
        char operation = '-';
        assertEquals("-2", controller.calculate(firstNumber, secondNumber, operation));
    }

    @Test
    public void calculateDivTest() {
        Controller controller = new Controller();
        int firstNumber = 8;
        int secondNumber = 4;
        char operation = '/';
        assertEquals("2", controller.calculate(firstNumber, secondNumber, operation));
    }

    @Test
    public void calculatemultiplyTest() {
        Controller controller = new Controller();
        int firstNumber = 3;
        int secondNumber = 5;
        char operation = '*';
        assertEquals("15", controller.calculate(firstNumber, secondNumber, operation));
    }

    @Test
    public void divByZeroTest() {
        Controller controller = new Controller();
        int firstNumber = 3;
        int secondNumber = 0;
        char operation = '/';
        assertEquals("ERROR", controller.calculate(firstNumber, secondNumber, operation));
    }
}