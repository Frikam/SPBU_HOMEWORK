package group144.tetin;

/** A class represent calculator */
public class Calculator {
    /** Calculate using the sorting station algorithm */
    public static int calculate(String string) throws WrongExpressionException {
        Stack<Integer> stack = new ListStack<>();
        String[] array = string.split(" ");
        for (String expression : array) {
            if (isNumber(expression)) {
                stack.push(Integer.parseInt(expression));
            }
            else {
                try {
                    Integer firstNumber = stack.pop();
                    Integer secondNumber = stack.pop();
                    stack.push(calculate(secondNumber, firstNumber, expression));
                }
                catch (EmptyStackException e) {
                    throw new WrongExpressionException();
                }
            }
        }

        int answer;

        try{
            answer = stack.pop();
        }
        catch (EmptyStackException e){
            throw new WrongExpressionException();
        }

        return answer;
    }

    /** Calculate expression */
    private static Integer calculate(Integer firstNumber, Integer secondNumber, String symbol) throws WrongExpressionException {
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
    private static boolean isNumber(String expression){
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
