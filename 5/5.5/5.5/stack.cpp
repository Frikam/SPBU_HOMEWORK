#include <iostream>

#include "stack.hpp"

using namespace std;

List *createList()
{
    return new List {nullptr};
}

void stackPushSign(List *list, char c)
{
    ListElement *current = new ListElement;
    current->sign = c;
    current->next = list->top;
    list->top = current;
    
}

void saveStack(List *list, char *postfixForm, int *index)
{
    ListElement *current = list->top;
    while (current)
    {
        postfixForm[*index] = current->sign;
        (*index)++;
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

int size(List *list)
{
    ListElement *current = list->top;
    int length = 0;
    
    while (current)
    {
        length++;
        current = current->next;
    }
    return length;
}

char getFirstSign(List *list)
{
    return list->top->sign;
}

void clearList(List *list)
{
    ListElement *current = list->top;
    while (current)
    {
        ListElement *nextElement = current->next;
        delete current;
        current = nextElement;
    }
}

void stackPushNumber(List *list, int c)
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
        printf("%d\n", current->number);
        current = current->next;
    }
}

int getFirstNumber(List *list)
{
    return list->top->number;
}
int getSecondNumber(List *list)
{
    return list->top->next->number;
}
