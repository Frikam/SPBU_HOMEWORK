package group144.tetin;

/** A class represent calculator */
public class Calculator {
    /** Calculate using the sorting station algorithm */
    public int calculate(String string) throws EmptyStackException, WrongExpressionException {
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

        int answer = 0;

        try{
            answer = stack.pop();
        }
        catch (EmptyStackException e){
            throw e;
        }

        return answer;
    }

    /** Calculate expression */
    private Integer calculate(Integer firstNumber, Integer secondNumber, String symbol) throws WrongExpressionException {
        switch (symbol) {
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return firstNumber / secondNumber;
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            default:
                throw new WrongExpressionException();
        }
    }

    /** Checks if a string is a number */
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
