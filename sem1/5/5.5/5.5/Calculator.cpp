#include <string.h>

#include <iostream>

#include "stack.hpp"

#include "FromInfixToPostfix.hpp"

#include "Calculator.hpp"

using namespace std;

void infixToPostfix(char *line, char *postfixForm)
{
    int index = 0;
    Stack *stackSign = createList();

    for (int i = 0; i < strlen(line); i++)
    {
        addElementInStack(stackSign, line, postfixForm, i, index);
    }
    
    saveStack(stackSign, postfixForm, index);
    deleteStack(stackSign);
}

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

void calculateAnswer(char *postfixForm)
{
    Stack *stackNumber = createList();
    
    calculateAnswer(stackNumber, postfixForm);
    
    cout << "Answer : ";
    print(stackNumber);
    deleteStack(stackNumber);
}
