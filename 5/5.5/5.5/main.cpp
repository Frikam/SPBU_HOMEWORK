#include <iostream>

#include <string.h>

#include "stack.hpp"

#include "Calculator.hpp"

#include "FromInfixToPostfix.hpp"

using namespace std;

int main()
{
    cout << "Program converts the infix form of an expression into a Postfix form and calculate  the expression" << endl;
    cout << "Enter expression : ";
    const int maxLength = 10000;
    char *line = new char[maxLength];
    char *postfixForm = new char[maxLength];
    cin.getline(line, maxLength);
    
    infixToPostfix(line, postfixForm);
    
    calculateAnswer(postfixForm);
    
    delete[] line;
    delete[] postfixForm;
    return 0;
}

