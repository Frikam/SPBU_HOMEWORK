#include <iostream>

#include <string.h>

#include "list.hpp"

using namespace std;

List *createList()
{
    return new List {nullptr};
}

void add(List *list, long long x, char word[])
{
    ListElement *current = new ListElement;
    current->number = x;
    long long length = strlen(word);
    
    for (int i = 0; i < length; i++)
    {
        current->name[i] = word[i];
    }
    
    current->next = list->first;
    list->first = current;
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
