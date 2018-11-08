#include <iostream>

#include "FromInfixToPostfix.hpp"

#include "stack.hpp"

using namespace std;

int main()
{
    cout << "Program converts the infix form of an expression into a Postfix form" << endl;
    cout << "Enter expression : ";
    List *stack = createList();
    const int maxLength = 10000;
    char *line = new char[maxLength];
    char postfixForm[maxLength];
    int index = 0;
    cin.getline(line, maxLength);
    cout << "Infix form : ";

    for (int i = 0; i < strlen(line); i++)
    {
        if (line[i] != ' ')
        {
            if (line[i] == '('){
                stackPush(stack, line[i]);
            }
            else if (line[i] == ')'){
                deleteUntilOpenedBracket(stack, postfixForm, &index);
            }
            else if (priorityOfSign(line[i]) == 0){
                postfixForm[index] = line[i];
                index++;
                cout << line[i] << ' ';
            }
            else
            {
                if (size(stack) == 0 || getTop(stack) == '('){
                    stackPush(stack, line[i]);
                }
                else{
                    if (priorityOfSign(line[i]) > priorityOfSign(stack->top->sign)){
                        stackPush(stack, line[i]);
                    }
                    else{
                        deleteUntilOpenedBracketOrPriorityLower(stack, line[i], postfixForm, &index);
                        stackPush(stack, line[i]);
                    }
                }
            }
        }
    }
    
    print(stack, postfixForm, &index);
    deleteList(stack);
    return 0;
}

