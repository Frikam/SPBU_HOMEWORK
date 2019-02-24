#include <iostream>

#include <string.h>

#include "Calculator.hpp"

using namespace std;

int main()
{
    cout << "Program calculates the value of the expression in the Postfix notation" << endl;
    cout << "Enter expression : ";
    const int maxLength = 10000;
    char *line = new char[maxLength];
    cin.getline(line, maxLength);
    int firstNumber = 0;
    int secondNumber = 0;
    Stack *stack = createList();

    for (int i = 0; i < strlen(line); i++)
    {
        if (line[i] != ' '){
            if (line[i] >= '0' && line[i] <= '9')
            {
                stackPush(stack, line[i] - '0');
            }
            else
            {
                firstNumber = stackPop(stack);
                secondNumber = stackPop(stack);
                calculate(stack, secondNumber, firstNumber, line[i]);
            }
        }
    }
    
    cout << "Answer : ";
    print(stack);
    deleteStack(stack);
    delete[] line;
    return 0;
}
