#include <iostream>

#include "stack.hpp"

#include "FromInfixToPostfix.hpp"

using namespace std;

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
        cout << current->sign << ' ';
        ListElement *nextElement = current->next;
        list->top = nextElement;
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
        cout << current->sign << ' ';
        ListElement *nextElement = current->next;
        list->top = current->next;
        delete current;
        current = nextElement;
    }
    
    ListElement *nextElement = current->next;
    list->top = nextElement;
    delete nextElement;
}
