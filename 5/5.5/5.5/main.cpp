#include <iostream>

#include <string.h>

#include "stack.hpp"

#include "Calculator.hpp"

using namespace std;

int main()
{
    cout << "Program converts the infix form of an expression into a Postfix form and calculate  the expression" << endl;
    cout << "Enter expression : ";
    List *stackSign = createList();
    const int maxLength = 10000;
    char *line = new char[maxLength];
    char *postfixForm = new char[maxLength];
    int index = 0;
    int firstNumber = 0;
    int secondNumber = 0;
    cin.getline(line, maxLength);
    
    for (int i = 0; i < strlen(line); i++)
    {
        addElementInStacAndInArray(stackSign, line, postfixForm, i, &index);
    }
    
    saveStack(stackSign, postfixForm, &index);
    deleteList(stackSign);
    
    List *stackNumber = createList();
    
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
                firstNumber = getFirstNumber(stackNumber);
                secondNumber = getSecondNumber(stackNumber);
                calculator(stackNumber, secondNumber, firstNumber, postfixForm[i]);
            }
        }
    }
    
    cout << "Answer : ";
    print(stackNumber);
    deleteList(stackNumber);
    delete[] line;
    delete[] postfixForm;
    return 0;
}

