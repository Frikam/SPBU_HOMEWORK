#include <iostream>

#include "list.h"

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

void print(List *list)
{
    ListElement *current = list->first;
    
    while (current)
    {
        cout << "Number : " << current->value << " Number of repetitions : " << current->count << endl;
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

void add(List *list, int number)
{
    ListElement *current = list->first;
    
    if ((list->first == nullptr) || (current->value > number))
    {
        list->first = new ListElement {number, 1, list->first};
        return;
    }
    
    if (current->value == number)
    {
        current->count++;
        return;
    }
    
    while ((current->next) && (current->next->value < number))
    {
        current = current->next;
    }
    
    if (current->next && current->next->value == number)
    {
        current->next->count++;
        return;
    }
    
    ListElement *newElement = new ListElement {number, 1, current->next};
    current->next = newElement;
}
