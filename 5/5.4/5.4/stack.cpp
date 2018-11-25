#include "stack.hpp"

#include <iostream>

using namespace std;

Stack *createList()
{
    return new Stack {nullptr};
}

void stackPush(Stack *list, int value)
{
    StackElement *current = new StackElement {value, list->top};
    list->top = current;
}

void print(Stack *list)
{
    StackElement *current = list->top;
    while (current)
    {
        cout << current->number << ' ';
        current = current->next;
    }
}

int stackPop(Stack *list)
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

int getFirstNumber(Stack *list)
{
    return list->top->next->number;
}
int getSecondNumber(Stack *list)
{
    return list->top->number;
}
