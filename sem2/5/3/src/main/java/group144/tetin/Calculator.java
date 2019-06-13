package group144.tetin;

import java.util.Stack;

public class Calculator {
    private Stack<Character> stackSign;
    private String postfixForm;

    /** A method that calculate expression using sort station */
    public String calculateExpression(String expression) throws WrongExpressionException {
        this.postfixForm = "";
        try {
            infixToPostfix(expression.toCharArray());
            return "" + calculate(postfixForm);
        }
        catch (ArithmeticException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new WrongExpressionException();
        }
    }

    /** A method that create stack by sort station*/
    private void infixToPostfix(char[] line) {
        this.stackSign = new Stack<>();

        for (int i = 0; i < line.length; i++) {
            addElementInStack(line, i);
        }

        while (!stackSign.isEmpty()) {
            postfixForm += " " + stackSign.pop();
        }
    }

    /** A method that return priority of sign */
    public int priorityOfSign(char sign) {
        switch (sign) {
            case '*':
            case '/':
            case '%':
                return 2;

            case '+':
            case '-':
                return 1;
        }
        return 0;
    }

    /** A method that pop element from stack while priority of symbol less than elements from stack */
    private void deleteUntilOpenedBracketOrPriorityLower(char symbol) {
        char sign;
        if (!stackSign.isEmpty()) {
            sign = stackSign.pop();
            while (sign != '(' && (priorityOfSign(symbol) <= priorityOfSign(sign))) {
                postfixForm += sign + " ";
                if (!stackSign.isEmpty()) {
                    sign = stackSign.pop();
                } else {
                    break;
                }
            }
        }
    }

    /** A method that add element in stack from expression */
    private void addElementInStack(char[] line, int i) {
        if (line[i] != ' ') {
            if (priorityOfSign(line[i]) == 0 || (line[i] == '-' && priorityOfSign(line[i + 1]) == 0 && line[i + 1] != ' ')) {
                int j = i + 1;
                postfixForm += line[i];
                while (j < line.length && priorityOfSign(line[j]) == 0 && line[j] != ' ') {
                    postfixForm += line[j];
                    line[j] = ' ';
                    j++;
                }
                postfixForm += " ";

            } else if (stackSign.isEmpty() || stackSign.peek() == '(') {
                stackSign.push(line[i]);
            } else if (priorityOfSign(line[i]) > priorityOfSign(stackSign.peek())) {
                stackSign.push(line[i]);
            } else {
                deleteUntilOpenedBracketOrPriorityLower(line[i]);
                stackSign.push(line[i]);
            }
        }
    }

    /** Calculate using the sorting station algorithm */
    private int calculate(String string) throws RuntimeException {
        Stack<Integer> stack = new Stack<>();
        String[] array = string.split(" ");
        for (String expression : array) {
            if (expression.isEmpty()) {
                continue;
            }
            if (isNumber(expression)) {
                stack.push(Integer.parseInt(expression));
            }
            else {
                Integer firstNumber = stack.pop();
                Integer secondNumber = stack.pop();
                stack.push(calculate(secondNumber, firstNumber, expression));
            }
        }

        int answer;
        answer = stack.pop();

        postfixForm = "";
        return answer;
    }

    /** Calculate expression */
    private static Integer calculate(Integer firstNumber, Integer secondNumber, String symbol) throws ArithmeticException {
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
                return 0;
        }
    }

    /** Checks if a string is a number */
    private static boolean isNumber(String expression){
        int length = expression.length();
        if (length == 0) {
            return false;
        }
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



