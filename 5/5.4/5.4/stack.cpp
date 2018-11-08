#include "stack.hpp"

#include <iostream>

using namespace std;

List *createList()
{
    return new List {nullptr};
}

void stackPush(List *list, int c)
{
    ListElement *current = new ListElement;
    current->number = c;
    current->next = list->top;
    list->top = current;
}

void print(List *list)
{
    ListElement *current = list->top;
    while (current)
    {
        cout << current->number << ' ';
        current = current->next;
    }
}

void stackPop(List *list)
{
    ListElement *current = list->top;
    list->top = current->next;
    delete current;
}

void deleteList(List *list)
{
    ListElement *current = list->top;
    while (current)
    {
        ListElement *nextElement = current->next;
        delete current;
        current = nextElement;
    }
    
    delete list;
}

int getFirstNumber(List *list)
{
    return list->top->next->number;
}
int getSecondNumber(List *list)
{
    return list->top->number;
}
