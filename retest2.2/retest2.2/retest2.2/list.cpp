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
    ListElement *current =  new ListElement {number, list->first};
    list->first = current;
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

void sort(List *list, int length)
{
    ListElement *current = list->first;
    ListElement *pointer = list->first;
    ListElement *pointerOnMin = list->first;
    int min = current->value;
    
    for (int j = 0; j < length - 1; j++)
    {
        for (int i = j; i < length; i++)
        {
            if (min > pointer->value)
            {
                min = pointer->value;
                pointerOnMin = pointer;
            }
            
            pointer = pointer -> next;
        }
        
        pointerOnMin->value = current->value;
        current->value = min;
        current = current->next;
        pointerOnMin = current;
        pointer = current;
        min = pointer->value;
    }
}
