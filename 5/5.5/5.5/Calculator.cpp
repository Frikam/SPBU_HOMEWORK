#include "stack.hpp"

void calculate(Stack *list, int firstNumber, int secondNumber, char sign)
{
    int answer = 0;
    
    switch (sign)
    {
        case '*':
            answer = firstNumber * secondNumber;
            break;
        case '/':
            answer = firstNumber / secondNumber;
            break;
        case '+':
            answer = firstNumber + secondNumber;
            break;
        case '-':
            answer = firstNumber - secondNumber;
            break;
            
    }
    stackPushNumber(list, answer);
}

int priorityOfSign(char sign)
{
    switch (sign)
    {
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
