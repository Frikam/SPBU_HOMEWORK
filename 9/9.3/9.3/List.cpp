#include <iostream>

#include "List.hpp"

using namespace std;

List *createList()
{
    return new List {nullptr};
}

void listPush(List *list, int value)
{
    ListElement *current = list->top;
    if (!current)
    {
        list->top = new ListElement {value, nullptr};
        return;
    }
    while (current->next)
    {
        current = current->next;
    }
    
    current->next = new ListElement {value, nullptr};
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

void listPop(List *list)
{
    ListElement *current = list->top;
    ListElement *previous = current;
    if (!current->next)
    {
        delete current;
        list->top = nullptr;
        return;
    }
    
    while (current->next)
    {
        previous = current;
        current = current->next;
    }
    
    previous->next = nullptr;
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
