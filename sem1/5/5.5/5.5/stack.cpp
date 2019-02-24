#include <iostream>

#include "stack.hpp"

using namespace std;

Stack *createList()
{
    return new Stack {nullptr};
}


void stackPushNumber(Stack *list, int value)
{
    StackElement *current = new StackElement {value, ' ', list->top};
    list->top = current;
}

void stackPushSign(Stack *list, char sign)
{
    StackElement *current = new StackElement {0, sign, list->top};
    list->top = current;
}


void saveStack(Stack *list, char *postfixForm, int &index)
{
    StackElement *current = list->top;
    while (current)
    {
        postfixForm[index] = current->sign;
        index++;
        current = current->next;
    }
}

char stackPopSign(Stack *list)
{
    char sign = ' ';
    StackElement *current = list->top;
    list->top = current->next;
    sign = current->sign;
    delete current;
    return sign;
}

int stackPopNumber(Stack *list)
{
    int number = 0;
    StackElement *current = list->top;
    list->top = current->next;
    number = current->number;
    delete current;
    return number;
}

void deleteStack(Stack *list)
{
    StackElement *current = list->top;
    
    while (current)
    {
        StackElement *nextElement = current->next;
        delete current;
        current = nextElement;
    }
    
    delete list;
}

int size(Stack *list)
{
    StackElement *current = list->top;
    int length = 0;
    
    while (current)
    {
        length++;
        current = current->next;
    }
    return length;
}

char getFirstSign(Stack *list)
{
    return list->top->sign;
}

void clearList(Stack *list)
{
    StackElement *current = list->top;
    while (current)
    {
        StackElement *nextElement = current->next;
        delete current;
        current = nextElement;
    }
}


void print(Stack *list)
{
    StackElement *current = list->top;
    
    while (current)
    {
        printf("%d\n", current->number);
        current = current->next;
    }
}
