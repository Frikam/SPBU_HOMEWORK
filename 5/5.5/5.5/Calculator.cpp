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

void deleteUntilOpenedBracketOrPriorityLower(List *list, char sign1, char *postfixForm, int *index)
{
    ListElement *current = list->top;
    
    while (current && current->sign != '(' && priorityOfSign(sign1) <= priorityOfSign(current->sign))
    {
        postfixForm[*index] = current->sign;
        (*index)++;
        ListElement *nextElement = current->next;
        list->top = current->next;
        delete current;
        current = nextElement;
    }
}

void deleteUntilOpenedBracket(List *list, char *postfixForm, int *index)
{
    ListElement *current = list->top;
    
    while ( current->sign != '(')
    {
        postfixForm[*index] = current->sign;
        (*index)++;
        ListElement *nextElement = current->next;
        list->top = current->next;
        delete current;
        current = nextElement;
    }
    
    ListElement *nextElement = current->next;
    list->top = nextElement;
    delete current;
}

void addElementInStacAndInArray(List *stackSign, char *line, char *postfixForm, int i, int *index)
{
    if (line[i] != ' ')
    {
        if (line[i] == '('){
            stackPushSign(stackSign, line[i]);
        }
        else if (line[i] == ')'){
            deleteUntilOpenedBracket(stackSign, postfixForm, &*index);
        }
        else if (priorityOfSign(line[i]) == 0){
            postfixForm[*index] = line[i];
            (*index)++;
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
                    deleteUntilOpenedBracketOrPriorityLower(stackSign, line[i], postfixForm, *&index);
                    stackPushSign(stackSign, line[i]);
                }
            }
        }
    }
}
