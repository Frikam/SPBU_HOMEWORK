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

int isNumber(char sign)
{
    switch (sign)
    {
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
        case '7':
            return 7;
        case '8':
            return 8;
        case '9':
            return 9;
    }
    return -1;
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
