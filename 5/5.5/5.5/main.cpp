#include <iostream>

#include <string.h>

#include "stack.hpp"

#include "Calculator.hpp"

#include "FromInfixToPostFix.hpp"

using namespace std;

int main()
{
    cout << "Program converts the infix form of an expression into a Postfix form and calculate  the expression" << endl;
    cout << "Enter expression : ";
    Stack *stackSign = createList();
    const int maxLength = 10000;
    char *line = new char[maxLength];
    char *postfixForm = new char[maxLength];
    int index = 0;
    int firstNumber = 0;
    int secondNumber = 0;
    cin.getline(line, maxLength);
    
    for (int i = 0; i < strlen(line); i++)
    {
        addElementInStacAndInArray(stackSign, line, postfixForm, i, index);
    }
    
    saveStack(stackSign, postfixForm, index);
    deleteStack(stackSign);
    
    Stack *stackNumber = createList();
    
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
    
    cout << "Answer : ";
    print(stackNumber);
    deleteStack(stackNumber);
    delete[] line;
    delete[] postfixForm;
    return 0;
}

