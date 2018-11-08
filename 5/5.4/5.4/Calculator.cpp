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

int isNumber(char sign)
{
    switch (sign)
    {
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
        case '7':
            return 7;
        case '8':
            return 8;
        case '9':
            return 9;
    }
    return -1;
}
