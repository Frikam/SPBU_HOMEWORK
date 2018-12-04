#include <string.h>

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

void calculateAnswer(Stack *stackNumber,char *postfixForm)
{
    int firstNumber = 0;
    int secondNumber = 0;

    for (int i = 0; i < strlen(postfixForm); i++)
    {
        if (postfixForm[i] != ' ')
        {
            if (postfixForm[i] >= '0' && postfixForm[i] <= '9')
            {
                stackPushNumber(stackNumber, postfixForm[i] - '0');
            }
            
            else
            {
                firstNumber = stackPopNumber(stackNumber);
                secondNumber = stackPopNumber(stackNumber);
                calculate(stackNumber, secondNumber, firstNumber, postfixForm[i]);
            }
        }
    }
}
