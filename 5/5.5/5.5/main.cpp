#include <iostream>

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
        if (line[i] != ' ')
        {
            if (line[i] == '('){
                stackPushSign(stackSign, line[i]);
            }
            else if (line[i] == ')'){
                deleteUntilOpenedBracket(stackSign, postfixForm, &index);
            }
            else if (priorityOfSign(line[i]) == 0){
                postfixForm[index] = line[i];
                index++;
            }
            else
            {
                if (size(stackSign) == 0 || getFirstSign(stackSign) == '('){
                    stackPushSign(stackSign, line[i]);
                }
                else{
                    if (priorityOfSign(line[i]) > priorityOfSign(getFirstSign(stackSign))){
                        stackPushSign(stackSign, line[i]);
                    }
                    else{
                        deleteUntilOpenedBracketOrPriorityLower(stackSign, line[i], postfixForm, &index);
                        stackPushSign(stackSign, line[i]);
                    }
                }
            }
        }
    }
    
    saveStack(stackSign, postfixForm, &index);
    deleteList(stackSign);
    
    List *stackNumber = createList();
    
    for (int i = 0; i < strlen(postfixForm); i++)
    {
        if (postfixForm[i] != ' '){
            if (isNumber(postfixForm[i]) != -1){
                stackPushNumber(stackNumber, isNumber(postfixForm[i]));
            }
            else{
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

