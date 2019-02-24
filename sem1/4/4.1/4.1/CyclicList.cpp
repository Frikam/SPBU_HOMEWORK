#include <iostream>

#include "CyclicList.hpp"

using namespace std;

CyclicList *createList()
{
    return new CyclicList {};
}

void add(CyclicList *list, int x)
{
    ListElement *current = list->first;
    
    if ((list->first == nullptr) || (current->value > x))
    {
        list->first = new ListElement {x, list->first};
        return;
    }
    
    while (current->next && current->next->value != 1)
    {
        current = current->next;
    }
    
    ListElement *newElement = new ListElement {x, list->first};
    current->next = newElement;
}
void deleteElement(ListElement *current)
{    
    ListElement *nextElement = current->next;
    current->next = nextElement->next;
    delete nextElement;
}

void deleteList(CyclicList *list)
{
    ListElement *current = list->first;
    ListElement *nextElement = current->next;
    delete nextElement;
    delete current;
    delete list;
}

void printElement(ListElement *current)
{
    cout << current->value;
}

void makeNewFirstElement(CyclicList *list, ListElement *current)
{
    list->first = current;
}

ListElement *getPointerOnFirstElement(CyclicList *list)
{
    return list->first;
}

void pointerOnNextWarrior(ListElement *&current)
{
    current = current->next;
}
