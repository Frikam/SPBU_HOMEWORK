#include "stack.hpp"

void calculate(Stack *stack, int firstNumber, int secondNumber, char sign)
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
    stackPush(stack, answer);
}

