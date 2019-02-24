#include "stack.hpp"

#include "FromInfixToPostfix.hpp"

#include <iostream>

using namespace std;

List *createList()
{
    return new List {nullptr};
}

void stackPush(List *list, char character)
{
    ListElement *current = new ListElement;
    current->sign = character;
    current->next = list->top;
    list->top = current;
    
}

void print(List *list, char *postfixForm, int *index)
{
    ListElement *current = list->top;
    while (current)
    {
        postfixForm[*index] = current->sign;
        (*index)++;
        cout << current->sign << ' ';
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

char getTop(List *list)
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

