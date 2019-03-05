package group144.tetin;

import java.util.List;

public class Calculator {
    public int calculate(String string) {
        Stack<Integer> stack = new ListStack<>();
        String[] array = string.split(" ");
        for (String expression : array) {
            if (isNumber(expression)) {
                stack.push(Integer.parseInt(expression));
            }
            else {
                Integer firstNumber = stack.pop();
                Integer secondNumber = stack.pop();
                stack.push(calculate(secondNumber, firstNumber, expression));
            }
        }
        return stack.pop();
    }

    private Integer calculate(Integer firstNumber, Integer secondNumber, String symbol) {
        switch (symbol) {
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return firstNumber / secondNumber;
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
        }
        return 0;
    }

    private boolean isNumber(String expression){
        int length = expression.length();
        char symbol;
        for (int i = 1; i < length; i++) {
            symbol = expression.charAt(i);
            if (!(Character.isDigit(symbol))) {
                return false;
            }
        }
        symbol = expression.charAt(0);
        return symbol == '-' && length > 1 || Character.isDigit(symbol);
    }
}
