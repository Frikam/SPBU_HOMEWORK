#include "list.hpp"

#include <iostream>

using namespace std;

List *createList()
{
    return new List {nullptr};
}

void deleteList(List *list)
{
    ListElement *current = list->first;
    
    while (current)
    {
        ListElement *nextElement = current->next;
        delete current;
        current = nextElement;
    }
    
    delete list;
}

void add(List *list, int number)
{
    ListElement *current = list->first;
    
    if (!current)
    {
        list->first = new ListElement{number, nullptr};
        return;
    }
    
    while (current->next)
    {
        current = current->next;
    }
    
    current->next = new ListElement{number, nullptr};
}

void print(List *list)
{
    ListElement *current = list->first;
    
    while (current)
    {
        cout << current->value << ' ';
        current = current->next;
    }
    
    cout << endl;
}

int size(List *list)
{
    ListElement *current = list->first;
    int length = 0;
    
    while (current)
    {
        length++;
        current = current->next;
    }
    return length;
}
