#include "stack.hpp"

void calculator(List *list, int firstNumber, int secondNumber, char sign)
{
    int answer = 0;
    stackPop(list);
    stackPop(list);
    
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
    stackPush(list, answer);
}

