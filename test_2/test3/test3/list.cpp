#include "list.h"

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

void print(List *list, ofstream &output)
{
    ListElement *current = list->first;
    while (current->next)
    {
        output << current->value << ' ';
        current = current->next;
    }
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

int getElement(List *list, int index)
{
    ListElement *current = list->first;
    int count = 0;
    while (current)
    {
        if (count == index)
            return current->value;
        count += 1;
        current = current->next;
    }
    return -1;
}

void add(List *list, int x)
{
    ListElement *current = list->first;
    if (list->first == nullptr)
    {
        list->first = new ListElement {x, list->first};
        return;
    }
    
    while (current->next)
    {
        current = current->next;
    }
    current->next = new ListElement {x, nullptr};;
}
