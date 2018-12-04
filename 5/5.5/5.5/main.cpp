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
    cin.getline(line, maxLength);
    
    for (int i = 0; i < strlen(line); i++)
    {
        addElementInStack(stackSign, line, postfixForm, i, index);
    }
    
    saveStack(stackSign, postfixForm, index);
    deleteStack(stackSign);
    
    Stack *stackNumber = createList();
    
    calculateAnswer(stackNumber, postfixForm);
    
    cout << "Answer : ";
    print(stackNumber);
    deleteStack(stackNumber);
    delete[] line;
    delete[] postfixForm;
    return 0;
}

